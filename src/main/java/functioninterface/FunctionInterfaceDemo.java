package functioninterface;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式接口demo
 * @author yinyg
 * @date 2022/5/11
 */
public class FunctionInterfaceDemo {

    /**
     * @throws
     * @description 自定义函数式接口demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void myFunctionInterfaceDemo() {
        MyFunctionInterface<Integer, Integer> f = v -> v + 2;
        System.out.println(f.apply(1));
    }

    /**
     * @throws
     * @description BiFunction demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void biFunctionDemo() {
        BiFunction<Integer, Integer, Integer> b = (v1, v2) -> v1 + v2;
        Function<Integer, String> after = v -> "result=" + v;
        System.out.println(b.andThen(after).apply(1, 2));
    }

    /**
     * @throws
     * @description BiConsumer demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void biConsumerDemo() {
        BiConsumer<Integer, Integer> b = (v1, v2) -> System.out.printf("%d + %d = %d%n", v1, v2, v1 + v2);
        BiConsumer<Integer, Integer> b2 = (v1, v2) -> System.out.printf("%d * %d = %d%n", v1, v2, v1 * v2);
        b.andThen(b2).accept(10, 10);
    }

    /**
     * @throws
     * @description Supplier demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void supplierDemo() {
        System.out.println(MySupplierDemo.checkOrElse(null, () -> 1));
    }

    /**
     * @throws
     * @description 闭包demo
     * @author yinyg
     * @date 2022/5/11
     */
    @Test
    public void closure() {
        Supplier<Integer> s = null;
        {
            int i = 1;
            s = () -> i;
        }
        if (s != null) {

        }
        System.out.println(s.get());
    }

}

@FunctionalInterface
interface MyFunctionInterface<T, U> {
    U apply(T t);
}

class MySupplierDemo {
    public static Integer checkOrElse(Integer i, Supplier<Integer> s) {
        return i != null ? i : s.get();
    }
}
