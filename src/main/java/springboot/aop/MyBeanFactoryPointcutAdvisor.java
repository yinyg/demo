package springboot.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;

/**
 * @author yinyg
 * @date 2023/5/4
 */
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class MyBeanFactoryPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    /** 切点 */
    private MyPointcut pointcut = new MyPointcut();

    {
        setAdvice(new MyPointcutMethodInterceptor());
    }

    /**
     * getPointcut
     *
     * @return org.springframework.aop.Pointcut
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

}
