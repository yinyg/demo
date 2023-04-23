package springboot.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean生命周期demo bean后置处理器
 * @author yinyg
 * @date 2023/4/22
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("beanLifeCycleDemo".equals(beanName)) {
            System.out.println("10. invoke postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("beanLifeCycleDemo".equals(beanName)) {
            System.out.println("13. invoke postProcessAfterInitialization");
        }
        return bean;
    }
}
