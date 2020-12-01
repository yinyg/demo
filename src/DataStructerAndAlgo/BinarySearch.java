package DataStructerAndAlgo;

/**
 * @author yinyg
 * @date 2020/11/24
 * @description 二分查找
 */
public class BinarySearch {
    /**
     * @description 循环实现
     * @param a 数据源
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/24
     */
    public static int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0, high = a.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @description 二分查找，递归实现
     * @param a 数据源
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/24
     */
    public static int binarySearchRecursive(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        return binarySearchRecursive(a, 0, a.length - 1, target);
    }

    /**
     * @description 二分查找，递归实现
     * @param a 数据源
     * @param low 开始边界
     * @param high 结束边界
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/24
     */
    public static int binarySearchRecursive(int[] a, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return binarySearchRecursive(a, mid + 1, high, target);
        } else {
            return binarySearchRecursive(a, low, mid - 1, target);
        }
    }

    /**
     * @description 查找第一个值等于给定值的元素
     * @param a 从小到大排列的有序数组
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/29
     */
    public static int searchFirstEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0, high = a.length - 1, mid;
        int result = -1;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * @description 查找最后一个值等于给定值的元素
     * @param a 从小到大排列的有序数组
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/29
     */
    public static int searchLastEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0, high = a.length - 1, mid;
        int result = -1;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * @description 查找第一个大于等于给定值的元素
     * @param a 从小到大排列的有序数组
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/29
     */
    public static int searchFirstGreaterOrEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0, high = a.length - 1, mid;
        int result = -1;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * @description 查找最后一个小于等于给定值的元素
     * @param a 从小到大排列的有序数组
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/29
     */
    public static int searchLastLessOrEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0, high = a.length - 1, mid;
        int result = -1;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[mid] <= target) {
                result = mid;
                low = mid + 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * @description 从循环有序数组中查找值等于给定值的元素
     * @param a 循环有序数组
     * @param target 目标值
     * @return int
     * @throws
     * @author yinyg
     * @date 2020/11/29
     */
    public static int searchFromCircleSortedArray(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        // 1、查找第一个小于等于数组首个元素的值的位置，得到的值即为偏移量
        // 2、假设数据按照从小到达排列，根据公式: (元素应该所处位置的下标 + 偏移量) % 数组长度，得到元素实际下标
        int offset = searchFirstGreaterOrEqual(a, target);
        int length = a.length;
        int low = 0, high = length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (a[(mid + 2) % length] == target) {
                return (mid + 2) % length;
            } else if (a[(mid + 2) % length] < target) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};
//        int index = binarySearch(a, 6);
//        int index = binarySearchRecursive(a, 6);
//        int index = searchFirstEqual(a, 7);
//        int index = searchLastEqual(a, 2);
//        int index = searchFirstGreaterOrEqual(a, 0);
//        int index = searchLastLessOrEqual(a, 9);
        int[] a = new int[]{5, 6, 1, 2, 3, 4};
        int index = searchFromCircleSortedArray(a, 5);
        System.out.println(index);
    }
}
