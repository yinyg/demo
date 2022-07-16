package DataStructerAndAlgo.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和问题
 *
 * from leetcode NO.120 https://leetcode.cn/problems/triangle
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author yinyg
 * @date 2022/7/6
 */
public class MinimumTotal {

    /**
     * 时间复杂度: O(n^2)，n表示行数；
     * 空间复杂度: O(n^2)，因为当前行状态只与上一行状态有关，空间复杂度可优化为O(n)，如果需要知道路径，则无法优化。
     *
     * @param triangle
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/6
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] states = new int[n][n];

        // 动态规划
        // 特殊处理第一行
        states[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            // 特殊处理第一列
            states[i][0] = states[i - 1][0] + triangle.get(i).get(0);
            // 计算每列的最短路径
            for (int j = 1; j < i; j++) {
                states[i][j] = Math.min(states[i - 1][j - 1], states[i - 1][j]) + triangle.get(i).get(j);
            }
            // 特殊处理最后一列
            states[i][i] = states[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // 寻找虽短路径
        int minimumTotal = states[n - 1][0];
        for (int j = 1; j < n; j++) {
            if (states[n - 1][j] < minimumTotal) {
                minimumTotal = states[n - 1][j];
            }
        }

        return minimumTotal;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        int minimumTotal = minimumTotal(lists);
        System.out.println("输入:");
        System.out.println(Arrays.toString(lists.get(0).toArray()));
        System.out.println(Arrays.toString(lists.get(1).toArray()));
        System.out.println(Arrays.toString(lists.get(2).toArray()));
        System.out.println(Arrays.toString(lists.get(3).toArray()));
        System.out.printf("最短路径: %d", minimumTotal);
    }

}
