package jvm;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinyg
 * @date 2022/5/12
 */
public class Demo {

    /**
     * @param args
     * @throws
     * @description 反射demo
     * @author yinyg
     * @date 2022/6/5
     */
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        try {
            Demo.class.getDeclaredMethod("test").invoke(new Demo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println("method test with no params invoked");
    }

    public void test(String s) {
        System.out.println("method test with one params invoked");
    }

    public void test(String s, String s2) {
        System.out.println("method test with two params invoked");
    }

    /**
     * @throws
     * @description Tomcat自定义WebappClassLoader demo
     * @author yinyg
     * @date 2022/5/15
     */
    @Test
    public void MyWebappClassLoaderDemo() throws Exception {
        MyWebappClassLoader myWebappClassLoader1 = new MyWebappClassLoader(MyWebappClassLoader.class.getResource("version1").getPath());
        Class userClass1 = myWebappClassLoader1.loadClass("jvm.User");
        System.out.println(userClass1.getClassLoader());
        Method method1 = userClass1.getDeclaredMethod("print");
        Object object1 = userClass1.newInstance();
        System.out.println(object1);
        method1.invoke(object1);
        System.out.println();
        Class userClass11 = myWebappClassLoader1.loadClass("jvm.User");
        System.out.println(userClass11.getClassLoader());
        Method method11 = userClass11.getDeclaredMethod("print");
        Object object11 = userClass11.newInstance();
        System.out.println(object11);
        method11.invoke(object11);
        System.out.println("----------------------------------");
        MyWebappClassLoader myWebappClassLoader2 = new MyWebappClassLoader(MyWebappClassLoader.class.getResource("version2").getPath());
        Class userClass2 = myWebappClassLoader2.loadClass("jvm.User");
        System.out.println(userClass2.getClassLoader());
        Method method2 = userClass2.getDeclaredMethod("print");
        Object object2 = userClass2.newInstance();
        System.out.println(object2);
        method2.invoke(object2);
    }

    public int compute() {
        List list = new ArrayList<>();
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

}
