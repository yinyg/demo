package DataStructerAndAlgo.Sort;

import java.util.Arrays;

/**
 * @author yinyg
 * @date 2020/10/24
 * @description 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。
 * 每次冒泡操作都会对相邻的两个元素进行比较，
 * 看是否满足大小关系要求。如果不满足就让它俩互换。
 * 一次冒泡会让至少一个元素移动到它应该在的位置，
 * 重复 n 次，就完成了 n 个数据的排序工作。
 */
public class BubbleSortAlgo {
    public static void main(String[] args) {
        // 排序
        int[] arr = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sort(arr);
//        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        for (int i = 0; i < length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                // 交换
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }

    /**
     * @description 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     * @param a
     * @throws
     * @author yinyg
     * @date 2020/8/11
     */
    public static void sort2(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int length = a.length;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = length - 1;
        for (int i = 0; i < length; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }
}
