package DataStructerAndAlgo.dynamicProgramming;

import java.util.Arrays;

/**
 * 0-1背包问题升级版
 *
 * 在不超过背包最大承受重量的前提下，求能装入背包的石头的最大总价值。
 *
 * @author yinyg
 * @date 2022/7/6
 */
public class BagFor01Value {

    /**
     * 0-1背包问题升级版
     *
     * 时间复杂度: O(n * limit)；
     * 空间复杂度: O(n * limit)，因为当前行状态只与上一行状态有关，空间复杂度可优化为O(limit)，如果需要知道装入了哪些石头，则无法优化。
     *
     * @param weights 石头重量
     * @param values 石头价值 values[i] > 0
     * @param n 石头数量
     * @param limit 背包最大承重
     * @throws
     * @author yinyg
     * @date 2022/7/6
     */
    public static void maxValue(int[] weights, int[] values, int n, int limit) {
        int[][] states = new int[n][limit + 1];

        // 动态规划
        // 特殊处理第一行
        if (weights[0] <= limit) {
            states[0][weights[0]] = values[0];
        }
        for (int i = 1; i < n; i++) {
            // 不装入第i块石头
            for (int j = 0; j <= limit; j++) {
                if (states[i - 1][j] > 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 装入第i块石头
            int v;
            for (int j = 0; j <= limit - weights[i]; j++) {
                if (states[i - 1][j] > 0) {
                    v =  states[i - 1][j] + values[i];
                    if (v > states[i][j + weights[i]]) {
                        states[i][j + weights[i]] = v;
                    }
                }
            }
        }

        // 寻找最大价值
        int lastLine = n - 1;
        int max = states[lastLine][0];
        for (int j = 0; j <= limit; j++) {
            if (states[lastLine][j] > max) {
                max = states[lastLine][j];
            }
        }
        System.out.printf("石头重量: %s%n", Arrays.toString(weights));
        System.out.printf("石头价值: %s%n", Arrays.toString(values));
        if (max == 0) {
            System.out.println("无法装入任何一块石头");
            return;
        }
        System.out.printf("能装入背包的石头的最大总价值: %s", max);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 7, 4, 2, 6, 8, 14, 10};
        int[] values = new int[]{5, 8, 1, 3, 10, 9, 13, 14, 2};
        maxValue(weights, values, weights.length, 10);
    }

}
