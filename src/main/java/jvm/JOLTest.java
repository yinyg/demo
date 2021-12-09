package jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author yinyg
 * @date 2021/3/28
 * @description
 */
public class JOLTest {

    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new Object());
        System.out.println(classLayout.toPrintable());

        ClassLayout classLayout2 = ClassLayout.parseInstance(new int[0]);
        System.out.println(classLayout2.toPrintable());

        ClassLayout classLayout3 = ClassLayout.parseInstance(new A());
        System.out.println(classLayout3.toPrintable());
    }

}

class A {
    private int a;
    private String b;
    private byte c;
    private Object d;
}
