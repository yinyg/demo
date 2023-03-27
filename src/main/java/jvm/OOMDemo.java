package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
 * @author yinyg
 * @date 2022/6/23
 */
public class OOMDemo {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        while (true) {
            list.add(new User());
        }
    }

}
