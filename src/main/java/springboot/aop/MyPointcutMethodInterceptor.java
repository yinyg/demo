package springboot.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author yinyg
 * @date 2023/5/4
 */
public class MyPointcutMethodInterceptor implements MethodInterceptor {

    /**
     * invoke
     *
     * @param invocation
     * @return java.lang.Object
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("start for " + invocation.getMethod().getDeclaringClass().getName() + "#" + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("end for " + invocation.getMethod().getDeclaringClass().getName() + "#" + invocation.getMethod().getName());
        return result;
    }

}
