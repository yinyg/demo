package springboot.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean生命周期demo InstantiationAwareBeanPostProcessor
 * @author yinyg
 * @date 2023/4/22
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("beanLifeCycleDemo".equals(beanName)) {
            System.out.println("2. invoke postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("beanLifeCycleDemo".equals(beanName)) {
            System.out.println("4. invoke postProcessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("beanLifeCycleDemo".equals(beanName)) {
            System.out.println("5. invoke postProcessProperties");
        }
        return null;
    }

}
