//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11442 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinyg
 * @date 2021-06-29 23:16:09
 * @description 1.两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
         Solution solution = new TwoSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        List<Integer> indexs = null;
//        for (int i = 0; i < nums.length; i++) {
//            indexs = map.get(nums[i]);
//            if (indexs == null) {
//                indexs = new ArrayList<>();
//                map.put(nums[i], indexs);
//            }
//            indexs.add(i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int num = target - nums[i];
//            indexs = map.get(num);
//            if (indexs != null) {
//                if (num == nums[i] && indexs.size() >= 2) {
//                    return new int[]{indexs.get(0), indexs.get(1)};
//                } else if (num != nums[i]) {
//                    return new int[]{i, indexs.get(0)};
//                }
//            }
//        }
//        return null;

        // 优化
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
