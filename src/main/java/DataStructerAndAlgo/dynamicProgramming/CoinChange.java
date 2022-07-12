package DataStructerAndAlgo.dynamicProgramming;

/**
 * 零钱兑换
 * from leetcode NO.322
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author yinyg
 * @date 2022/7/9
 */
public class CoinChange {

    /**
     * 动态规划
     *
     * 状态转移方程: f(i) = min(f(s - c[j])) + 1 (0 <= j < n)
     *
     * 时间复杂度: O(S * n)，S为需要兑换的总面值，n为不同硬币面值的种数
     * 空间复杂度: O(S)
     *
     * @param coins 硬币面值
     * @param amount 需要兑换的总面值
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/9
     */
    public static int solution(int[] coins, int amount) {
        int[] f = new int[amount + 1];

        // 动态规划
        // 特殊处理第一个值
        f[0] = 0;
        int min;
        int s;
        for (int i = 1; i <= amount; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                s = i - coins[j];
                if (s >= 0 && f[s] < min - 1) {
                    min = f[s] + 1;
                }
            }
            f[i] = min;
        }

        return f[amount] < Integer.MAX_VALUE ? f[amount] : -1;
    }

    /**
     * 回溯
     *
     * 时间复杂度: O(S * n)，S为需要兑换的总面值，n为不同硬币面值的种数
     * 空间复杂度: O(S)
     *
     * @param coins 硬币面值
     * @param amount 需要兑换的总面值
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/9
     */
    public static int solution2(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        return solution2(coins, amount, mem);
    }

    public static int solution2(int[] coins, int amount, int[] mem) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }

        int min = Integer.MAX_VALUE;
        int f;
        for (int j = 0; j < coins.length; j++) {
            f = solution2(coins, amount - coins[j], mem);
            if (f >= 0 && f < min - 1) {
                min = f + 1;
            }
        }

        mem[amount] = min < Integer.MAX_VALUE ? min : -1;
        return mem[amount];
    }

}
