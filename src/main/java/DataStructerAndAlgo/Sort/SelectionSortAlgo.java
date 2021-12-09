package DataStructerAndAlgo.Sort;

import java.util.Arrays;

/**
 * @author yinyg
 * @date 2020/10/24
 * @description 选择排序
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectionSortAlgo {
    public static void main(String[] args) {
        // 排序
        int[] arr = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 0; i < length - 1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            if (minIndex != i) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }
}
