package springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yinyg
 * @date 2022/10/27
 */
@Component("myBeanPostProcessor")
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleDemo".equals(beanName)) {
            System.out.println("invoke method postProcessBeforeInitialization for bean lifeCycleDemo");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleDemo".equals(beanName)) {
            System.out.println("invoke method postProcessAfterInitialization for bean lifeCycleDemo");
        }
        return bean;
    }

}
