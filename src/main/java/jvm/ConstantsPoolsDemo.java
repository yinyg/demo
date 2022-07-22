package jvm;

import org.junit.Test;

/**
 * 常量池&对象池demo
 * @author yinyg
 * @date 2022/6/29
 */
public class ConstantsPoolsDemo {

    @Test
    public void StringConstantsPoolsDemo() {
        System.out.println("123" == "123");
        System.out.println("123" == new String("123"));
        System.out.println();

        String s = new String("456");
        String s2 = new String("456");
        System.out.println(s == s2);
        System.out.println("456" == s);
        System.out.println("456" == s2);
        System.out.println();

        String s3 = new String("789");
        String s4 = s3.intern();
        System.out.println(s3 == s4);
        System.out.println();

        // jdk1.6，执行intern()方法，如果字符串在常量池不存在，则在常量池创建字符串
        // jdk1.7及以上，执行intern()方法，如果字符串在常量池不存在，则在常量池存放字符串在堆中的指针
        String s5 = new String("he") + new String("llo");
        String s6 = s5.intern();
        System.out.println(s5 == s6);
        System.out.println();

        // "java"是关键字，在JVM初始化的相关类里肯定早就被放进字符串常量池了
        String s7 = new String("ja") + new String("va");
        String s8 = s7.intern();
        System.out.println(s7 == s8);
    }

    @Test
    public void IntegerConstantsPoolsDemo() {
        Integer i = 1;
        Integer i2 = 2;
        System.out.println(i == i2);
    }

}
