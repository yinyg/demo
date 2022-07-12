package jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinyg
 * @date 2022/6/1
 */
public class GCDemo {

    /**
     * @param args
     * @throws
     * @description 对象在Eden区分配
     * Eden区存活的对象超过Survivor区大小时，对象将提前进入老年代
     * 参数: -Xmx256m -Xms256m -XX:+PrintGCDetails
     * @author yinyg
     * @date 2022/6/5
     */
    public static void main(String[] args) {
        byte[] allocation1 = new byte[50000*1024];
        byte[] allocation2 = new byte[10000*1024];

        byte[] allocation3 = new byte[8000*1024];

        byte[] allocation4 = new byte[1000*1024];
        byte[] allocation5 = new byte[1000*1024];
        byte[] allocation6 = new byte[1000*1024];
        byte[] allocation7 = new byte[1000*1024];
    }

    /**
     * @throws
     * @description 大对象直接进入老年代demo
     * 参数: -Xmx256m -Xms256m -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000000 -XX:+UseSerialGC
     * @author yinyg
     * @date 2022/6/5
     */
    @Test
    public void bigObjectDirectAllotToParOldGenDemo() {
        byte[] allocation = new byte[1001*1024];
    }

    /**
     * @throws
     * @description OOM demo
     * 参数: -Xmx10m -Xms10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./demo-oom-heapdump.hprof
     * @author yinyg
     * @date 2022/6/5
     */
    @Test
    public void OOMDemo() {
        List<User> list = new ArrayList<>();
        while (true) {
            list.add(new User());
        }
    }

}
