package springboot.aop.transaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * 自定义事务注解Interceptor
 * @author yinyg
 * @date 2023/5/5
 */
public class MyTransactionPointcutInterceptor implements MethodInterceptor {

    public final Log log = LogFactory.getLog(MyTransactionPointcutInterceptor.class);

    /**
     * invoke
     *
     * @param invocation
     * @return java.lang.Object
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("invoke method " + invocation.getMethod().getDeclaringClass().getName() + "#" + invocation.getMethod().getName() + " with MyTransactionPointcutInterceptor");
        PlatformTransactionManager platformTransactionManager = getPlatformTransactionManager();
        TransactionDefinition transactionDefinition = getTransactionDefinition();
        // 开启事务
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        log.info("开启事务");
        Object result = null;
        try {
            result = invocation.proceed();
            // 提交事务
            platformTransactionManager.commit(transactionStatus);
            log.info("提交事务");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // 回滚事务
            platformTransactionManager.rollback(transactionStatus);
            log.error("回滚事务");
            throw e;
        }
        return result;
    }

    /**
     * getPlatformTransactionManager
     *
     * @return org.springframework.transaction.PlatformTransactionManager
     * @throws
     * @author yinyg
     * @date 2023/5/6
     */
    public PlatformTransactionManager getPlatformTransactionManager() {
        return null;
    }

    /**
     * getTransactionDefinition
     *
     * @return org.springframework.transaction.TransactionDefinition
     * @throws
     * @author yinyg
     * @date 2023/5/6
     */
    public TransactionDefinition getTransactionDefinition() {
        return null;
    }

}
