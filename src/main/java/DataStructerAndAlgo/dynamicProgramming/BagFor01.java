package DataStructerAndAlgo.dynamicProgramming;

import java.util.Arrays;

/**
 * 0-1背包问题
 *
 * 在不超过背包最大承受重量的前提下，求能装入背包的石头的最大总重量。
 *
 * @author yinyg
 * @date 2022/7/6
 */
public class BagFor01 {

    /**
     * 0-1背包问题算法
     *
     * 时间复杂度: O(n * limit)；
     * 空间复杂度: O(n * limit)，因为当前行状态只与上一行状态有关，空间复杂度可优化为O(limit)，如果需要知道装入了哪些石头，则无法优化。
     *
     * @param weights 石头重量
     * @param n 石头数量
     * @param limit 背包最大承重
     * @throws
     * @author yinyg
     * @date 2022/7/6
     */
    public static void maxWeight(int[] weights, int n, int limit) {
        boolean[][] states = new boolean[n][limit + 1];

        // 动态规划
        // 特殊处理第一行
        states[0][0] = true;
        if (weights[0] <= limit) {
            states[0][weights[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            // 不装入第i块石头
            for (int j = 0; j <= limit; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            // 装入第i块石头
            for (int j = 0; j <= limit - weights[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weights[i]] = true;
                }
            }
        }

        // 寻找最大重量
        int lastLine = n - 1;
        for (int j = limit; j >= 0; j--) {
            if (states[lastLine][j]) {
                System.out.printf("石头重量: %s，背包最大承重: %d%n", Arrays.toString(weights), limit);
                System.out.printf("能装入背包的石头的最大总重量: %d", j);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 4, 1, 5, 7, 3, 9};
        maxWeight(weights, weights.length, 10);
    }

}
