package jvm;

/**
 * @author yinyg
 * @date 2022/6/23
 */
public class HighCPUDemo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        while (true) {
            demo.compute();
        }
    }

}
