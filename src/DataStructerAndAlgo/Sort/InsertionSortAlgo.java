package DataStructerAndAlgo.Sort;

import java.util.Arrays;

/**
 * @author yinyg
 * @date 2020/10/24
 * @description 插入排序
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，
 * 在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertionSortAlgo {
    public static void main(String[] args) {
        // 排序
        int[] arr = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sort(arr);
//        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 1; i < length; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }

    /**
     * @description 希尔排序 (插入排序改进)
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。
     * 这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，
     * 但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        int step = length / 2;
        while (step >= 1) {
            for (int i = step; i < length; i++) {
                int value = a[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < a[j]) {
                        a[j + step] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + step] = value;
            }
            step = step / 2;
        }
    }
}
