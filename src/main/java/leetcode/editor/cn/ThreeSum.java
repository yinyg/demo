//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3720 👎 0

  
package leetcode.editor.cn;

import java.util.*;

/**
 * @author yinyg
 * @date 2021-09-07 14:37:47
 * @description 15.三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        int size = list.size();
        int sum;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                sum = list.get(i) + list.get(j);
                if (set.contains(0 - sum)) {
                    result.add(new ArrayList<>(Arrays.asList(list.get(i), list.get(j), 0 - sum)));
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
