package springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.Resource;

/**
 * 测试bean生命周期
 * @author yinyg
 * @date 2022/10/27
 */
public class LifeCycleDemo implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean {

    @Resource
    private A a;

    public LifeCycleDemo() {
        System.out.println("bean lifeCycleDemo 构造方法: " + a);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("invoke bean lifeCycleDemo method setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("invoke bean lifeCycleDemo method setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("invoke bean lifeCycleDemo method setBeanName: " + a);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke bean lifeCycleDemo method afterPropertiesSet");
    }

    public void init() {
        System.out.println("invoke bean lifeCycleDemo method init");
    }

    public void destroy() {
        System.out.println("invoke bean lifeCycleDemo method destroy");
    }

}
