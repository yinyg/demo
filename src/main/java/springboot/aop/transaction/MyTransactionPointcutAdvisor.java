package springboot.aop.transaction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;

/**
 * @author yinyg
 * @date 2023/5/5
 */
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class MyTransactionPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private final MyTransactionPointcut myTransactionPointcut = new MyTransactionPointcut();

    private final MyTransactionPointcutInterceptor myTransactionPointcutInterceptor = new MyTransactionPointcutInterceptor() {
        /**
         * getPlatformTransactionManager
         *
         * @return org.springframework.transaction.PlatformTransactionManager
         * @throws
         * @author yinyg
         * @date 2023/5/6
         */
        @Override
        public PlatformTransactionManager getPlatformTransactionManager() {
            return platformTransactionManager;
        }

        /**
         * getTransactionDefinition
         *
         * @return org.springframework.transaction.TransactionDefinition
         * @throws
         * @author yinyg
         * @date 2023/5/6
         */
        @Override
        public TransactionDefinition getTransactionDefinition() {
            return transactionDefinition;
        }
    };

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

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
