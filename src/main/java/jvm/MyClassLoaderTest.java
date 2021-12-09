package jvm;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yinyg
 * @date 2021/3/25
 * @description 自定义类加载器
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String dir;

        public MyClassLoader(String dir) {
            this.dir = dir;
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            Class c = null;
            // 打破双亲委派机制
//            c = findClass(name);
            if ("jvm.Test".equals(name)) {
                c = findClass(name);
            } else {
                c = super.loadClass(name);
            }
            if (c == null) {
                throw new ClassNotFoundException(name);
            }
            return c;
        }

        @Override
        protected Class<?> findClass(String name) {
            Class c = null;
            try {
                byte[] data = loadByte(name);
                c = defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return c;
        }

        protected byte[] loadByte(String name) throws Exception {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(this.dir + "/"
                        + name.replaceAll("\\.", "/") + ".class");
                int len = fileInputStream.available();
                byte[] data = new byte[len];
                fileInputStream.read(data);
                return data;
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyClassLoaderTest.MyClassLoader myClassLoader = new MyClassLoaderTest.MyClassLoader("/Users/yinyougen/MyDocuments/temp");
        try {
            Class classz = myClassLoader.loadClass("jvm.Test");
            Object obj = classz.newInstance();
            Method[] methods = classz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
                m.invoke(obj);
            }
            System.out.println(obj.getClass().getClassLoader().getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
