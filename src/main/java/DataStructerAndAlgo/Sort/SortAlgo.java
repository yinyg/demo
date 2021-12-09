package DataStructerAndAlgo.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author yinyg
 * @CreateTime 2020/6/24 16:43
 * @Description 排序算法性能测试
 */
public class SortAlgo {
    public static void main(String[] args) {
        System.out.println("10000个数组，每个数组200个元素");
        int[][] array = new int[10000][200];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 200; j++) {
                array[i][j] = new Random().nextInt(10000);
            }
        }
        int[][] array2 = arrayDeepCopy(array);
        int[][] array3 = arrayDeepCopy(array);
        int[][] array4 = arrayDeepCopy(array);
        int[][] array5 = arrayDeepCopy(array);
        int[][] array6 = arrayDeepCopy(array);
        int[][] array7 = arrayDeepCopy(array);

        long bubbleSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            BubbleSortAlgo.sort(array[i]);
        }
        System.out.println("冒泡排序: " + (System.currentTimeMillis() - bubbleSortStartTime) + "ms");
        long bubbleSort2StartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            BubbleSortAlgo.sort2(array2[i]);
        }
        System.out.println("冒泡排序改进: " + (System.currentTimeMillis() - bubbleSort2StartTime) + "ms");

        long insertionSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            InsertionSortAlgo.sort(array3[i]);
        }
        System.out.println("插入排序: " + (System.currentTimeMillis() - insertionSortStartTime) + "ms");
        long shellSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            InsertionSortAlgo.shellSort(array4[i]);
        }
        System.out.println("希尔排序 (插入排序改进): " + (System.currentTimeMillis() - shellSortStartTime) + "ms");

        long selectionSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            SelectionSortAlgo.sort(array5[i]);
        }
        System.out.println("选择排序: " + (System.currentTimeMillis() - selectionSortStartTime) + "ms");

        long mergeSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            MergeSortAlgo.sort(array6[i]);
        }
        System.out.println("归并排序: " + (System.currentTimeMillis() - mergeSortStartTime) + "ms");

        long quickSortStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            QuickSortAlgo.sort(array7[i]);
        }
        System.out.println("快速排序: " + (System.currentTimeMillis() - quickSortStartTime) + "ms");
    }

    public static int[][] arrayDeepCopy(int[][] source) {
        if (source == null) {
            return null;
        }
        int[][] target = new int[10000][200];
        for (int i = 0; i < source.length; i++) {
            target[i] = Arrays.copyOf(source[i], 200);
        }
        return target;
    }
}
