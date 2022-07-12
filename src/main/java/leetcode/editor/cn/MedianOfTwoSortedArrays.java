//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4217 👎 0

  
package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2021-07-01 23:44:51
 * @description 4.寻找两个正序数组的中位数
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int mid = (m + n) / 2;
//        int[] nums = new int[mid + 1];
//        int i = 0, j = 0, k = 0;
//        while (i < m && j < n && k <= mid) {
//            if (nums1[i] <= nums2[j]) {
//                nums[k++] = nums1[i++];
//            } else {
//                nums[k++] = nums2[j++];
//            }
//        }
//        while (k <= mid && i < m) {
//            nums[k++] = nums1[i++];
//        }
//        while (k <= mid && j < n) {
//            nums[k++] = nums2[j++];
//        }
//        double result = nums[mid];
//        if ((m + n) % 2 == 0) {
//            result = (result + nums[mid - 1]) / 2;
//        }
//        return result;

        // 优化
        int m = nums1.length, n = nums2.length;
        int mid = (m + n) / 2;
        int[] nums = new int[2];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k <= mid) {
            if (nums1[i] <= nums2[j]) {
                nums[k % 2] = nums1[i];
                k++;
                i++;
            } else {
                nums[k % 2] = nums2[j];
                k++;
                j++;
            }
        }
        while (k <= mid && i < m) {
            nums[k % 2] = nums1[i];
            k++;
            i++;
        }
        while (k <= mid && j < n) {
            nums[k % 2] = nums2[j];
            k++;
            j++;
        }
        double result = nums[mid % 2];
        if ((m + n) % 2 == 0) {
            result = (result + nums[(mid - 1) % 2]) / 2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
