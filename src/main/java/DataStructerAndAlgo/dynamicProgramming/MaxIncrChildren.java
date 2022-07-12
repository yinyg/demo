package DataStructerAndAlgo.dynamicProgramming;

/**
 * 最长递增子序列长度
 *
 * 我们有一个数字序列包含 n 个不同的数字，求出这个序列中的最长递增子序列长度。
 *
 * @author yinyg
 * @date 2022/7/11
 */
public class MaxIncrChildren {

    /**
     * 动态规划
     *
     * states[i]表示前i个数字序列，必须包含第i个数字时，最长递增子序列长度
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     *
     * @param nums 数字序列
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/12
     */
    public static int max(int[] nums) {
        int n = nums.length;
        int[] states = new int[n];

        // 动态规划
        // 特殊处理states[0]
        states[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            states[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    states[i] = Math.max(states[i], states[j] + 1);
                }
            }
            max = Math.max(max, states[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{2, 9, 3, 6, 5, 1, 7}));
    }

}
