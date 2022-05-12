package Extends;

/**
 * @author yinyg
 * @date 2022/5/12
 */
public class Demo {

    public static void main(String[] args) {
        Son son = new Son();
        son.test();
    }

}

class Parent {
    public void test() {
        System.out.println("Parent method invoke");
    }
}

class Son extends Parent {
    @Override
    public void test() {
        Son.super.test();
    }
}
