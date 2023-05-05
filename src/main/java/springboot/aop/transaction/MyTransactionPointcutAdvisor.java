package springboot.aop.transaction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;

/**
 * @author yinyg
 * @date 2023/5/5
 */
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class MyTransactionPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private final MyTransactionPointcut myTransactionPointcut = new MyTransactionPointcut();

    private final MyTransactionPointcutInterceptor myTransactionPointcutInterceptor = new MyTransactionPointcutInterceptor();

    /**
     * getPointcut
     *
     * @return org.springframework.aop.Pointcut
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    @Override
    public Pointcut getPointcut() {
        return myTransactionPointcut;
    }

    /**
     * getAdvice
     *
     * @return org.aopalliance.aop.Advice
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    @Override
    public Advice getAdvice() {
        return myTransactionPointcutInterceptor;
    }

}
