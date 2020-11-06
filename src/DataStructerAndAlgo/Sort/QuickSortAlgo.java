package DataStructerAndAlgo.Sort;

import java.util.Arrays;

/**
 * @author yinyg
 * @date 2020/10/24
 * @description 快速排序
 */
public class QuickSortAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        System.out.println("数据: " + Arrays.toString(arr));

        // 排序
        sort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));

        // 借助快排，查找数组中第k大的元素
//        int k = 3;
//        int num = findKthNum(arr, 0, arr.length - 1, k);
//        System.out.println("第" + k + "大的元素: " + num);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortInternally(arr, 0, arr.length - 1);
    }

    /**
     * @description 快速排序递归函数，p,r为下标
     * @param arr
     * @param p
     * @param r
     * @throws
     * @author yinyg
     * @date 2020/8/21
     */
    private static void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        // 获取分区点
        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q-1);
        quickSortInternally(arr, q+1, r);
    }

    /**
     * @description 分区函数
     * @param arr
     * @param p
     * @param r
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/8/21
     */
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for(int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;

        return i;
    }

    /**
     * @description 借助快排，查找数组中第k大的元素
     * @param a
     * @param k
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/4
     */
    public static int findKthNum(int[] a, int p, int q, int k) {
        if (a == null || a.length < k) {
            return -1;
        }

        int length = a.length;
        int r = partition(a, p, q);
        if (r + k == length) {
            return a[r];
        } else if (r + k < length) {
            return findKthNum(a, r + 1, q, k);
        } else {
            return findKthNum(a, p, r - 1, k);
        }
    }
}
