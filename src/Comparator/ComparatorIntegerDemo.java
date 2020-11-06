package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yinyg
 * @date 2020/10/20
 * @description Comparator实现demo
 */
public class ComparatorIntegerDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(5);
                add(6);
                add(4);
                add(2);
            }
        };
        System.out.println("origin: " + list.toString());
        List<Integer> list2 = list.stream().sorted(Comparator.comparing(v -> v)).collect(Collectors.toList());
        System.out.println("result: " + list2.toString());
    }
}
