package springboot.aop.transaction;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 自定义事务注解Interceptor
 * @author yinyg
 * @date 2023/5/5
 */
public class MyTransactionPointcutInterceptor extends TransactionInterceptor {

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
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("invoke method " + invocation.getMethod().getDeclaringClass().getName() + "#" + invocation.getMethod().getName() + " with MyTransactionPointcutInterceptor");
        return super.invoke(invocation);
    }

}
