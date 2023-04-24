package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * MyMethodInterceptor
 * @author yinyg
 * @date 2023/4/24
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     * intercept
     *
     * @param obj     代理对象
     * @param method  被代理对象的方法
     * @param args    方法参数
     * @param proxy   代理对象的方法
     * @return java.lang.Object
     * @throws
     * @author yinyg
     * @date 2023/4/24
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("I am a cglib proxy.");
        proxy.invokeSuper(obj, args);
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Engineer.class);
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        enhancer.setCallback(myMethodInterceptor);
        Engineer engineer = (Engineer) enhancer.create();
        engineer.getJob();
    }

}
