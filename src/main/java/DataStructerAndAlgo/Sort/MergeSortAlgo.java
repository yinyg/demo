package DataStructerAndAlgo.Sort;

import java.util.Arrays;

/**
 * @author yinyg
 * @date 2020/10/24
 * @description 归并排序
 * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
 */
public class MergeSortAlgo {
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

        mergeSortInternally(a, 0, a.length-1);
    }

    /**
     * @description 递归调用函数
     * @param a
     * @param p
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * @description 合并
     * @param a
     * @param p
     * @param q
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void merge(int[] a, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q+1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                // i++等于i:=i+1
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

    /**
     * @description 合并(哨兵)
     * 当数组中存在2个以上(包括2个)Integer.MAX_VALUE时，不能使用该函数
     * @param arr
     * @param p
     * @param q
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/20
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }
}
