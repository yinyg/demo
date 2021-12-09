//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2901 👎 0

  
package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2021-07-05 22:16:07
 * @description 7.整数反转
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Integer.MAX_VALUE / 10 < result || Integer.MIN_VALUE / 10 > result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
