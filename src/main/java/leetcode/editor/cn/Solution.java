package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2022/3/26
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
