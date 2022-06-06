package jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author yinyg
 * @date 2022/5/15
 */
public class MyWebappClassLoader extends ClassLoader {

    private String classPath;

    public MyWebappClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 自定义类加载，打破双亲委派机制
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                if (!name.startsWith("jvm")) {
                    c = getParent().loadClass(name);
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    /**
     * @param name
     * @return java.lang.Class<?>
     * @throws
     * @description 加载类
     * @author yinyg
     * @date 2022/6/5
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }

    /**
     * 读取类的字节码文件
     * @param name
     * @return
     * @throws IOException
     */
    protected byte[] loadByte(String name) throws IOException {
        name = name.replaceAll("\\.", "/");
        try (FileInputStream  fileInputStream = new FileInputStream(classPath + "/" + name + ".class")) {
            int length = fileInputStream.available();
            byte[] data = new byte[length];
            fileInputStream.read(data);
            return data;
        }
    }

}
