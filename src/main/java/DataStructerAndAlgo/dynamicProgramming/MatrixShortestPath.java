package DataStructerAndAlgo.dynamicProgramming;

import java.util.Arrays;

/**
 * 矩阵中最短路径问题
 *
 * 给定一个 n * n 的矩阵，每个格子中的数字表示到达该格子需要的路径，从左上角开始，每次只能向右或者向下移动一格，求到达右下角的最短路径。
 *
 * @author yinyg
 * @date 2022/7/7
 */
public class MatrixShortestPath {

    /**
     * 矩阵中最短路径问题
     *
     * 时间复杂度: O(n^2)；
     * 空间复杂度: O(n^2)，因为当前行状态只与上一行状态有关，空间复杂度可优化为O(n)，如果需要知道路径，则无法优化。
     *
     * @param w 矩阵
     * @param n 矩阵 行数、列数
     * @throws
     * @author yinyg
     * @date 2022/7/7
     */
    public static void min(int[][] w, int n) {
        // 空间复杂度 O(n^2)，可优化为 O(n)
        int[][] states = new int[n][n];

        // 动态规划
        // 特殊处理左上角起点
        states[0][0] = w[0][0];
        // 特殊处理第一行
        for (int j = 1; j < n; j++) {
            states[0][j] = states[0][j - 1] + w[0][j];
        }
        // 特殊处理第一列
        for (int i = 1; i < n; i++) {
            states[i][0] = states[i -1][0] + w[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = Math.min(states[i - 1][j], states[i][j - 1]) + w[i][j];
            }
        }
        System.out.println("矩阵:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(w[i]));
        }
        System.out.printf("最短路径: %d", states[n - 1][n - 1]);
    }

    public static void main(String[] args) {
        int[][] w = new int[4][4];
        w[0] = new int[]{1, 3, 5, 9};
        w[1] = new int[]{2, 1, 3, 4};
        w[2] = new int[]{5, 2, 6, 7};
        w[3] = new int[]{6, 8, 4, 3};
        min(w, 4);
    }

}
