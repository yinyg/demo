package proxy.dynmaicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * my InvocationHandler
 * @author yinyg
 * @date 2023/4/24
 */
public class MyInvocationHandler<T> implements InvocationHandler {

    /** 被代理的对象 */
    private T target;

    public MyInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * invoke
     *
     * @param proxy   代理对象
     * @param method  被代理对象的方法
     * @param args    参数
     * @return java.lang.Object
     * @throws
     * @author yinyg
     * @date 2023/4/24
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I am a dynamix proxy.");
        method.invoke(target, args);
        return null;
    }

    public static void main(String[] args) {
        Person person = new Engineer();
        MyInvocationHandler<Person> myInvocationHandler = new MyInvocationHandler<>(person);
        Person personP = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, myInvocationHandler);
        personP.getJob();
    }

}
