package springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * bean生命周期demo
 * @author yinyg
 * @date 2022/10/27
 */
public class BeanLifeCycleDemo implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private A a;

    public BeanLifeCycleDemo() {
        System.out.println("3. 构造方法");
    }

    @Resource
    public void setA(A a) {
        System.out.println("6. invoke setA for dependency");
        this.a = a;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("7. invoke setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("8. invoke setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("9. invoke setBeanFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("11. invoke afterPropertiesSet");
    }

    public void myInit() {
        System.out.println("12. invoke myInit");
    }

    public void myDestroy() {
        System.out.println("15. invoke myDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("14. invoke destroy");
    }

}
