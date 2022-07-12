package DataStructerAndAlgo.dynamicProgramming;

import org.junit.Test;

/**
 * 字符串相似度问题
 *
 * 算法: 莱文斯坦距离、最长公共子串
 *
 * @author yinyg
 * @date 2022/7/10
 */
public class StringSimilarity {

    /**
     * 莱文斯坦距离
     *
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(m * n)
     *
     * 当a[i] != b[j]:
     * 1) i = i + 1，距离 +1，比较a[i + 1]、b[j]；
     * 2) j = j + 1，距离 +1，比较a[i]、b[j + 1]；
     * 3) i = i + 1；j = j + 1，距离 +1，比较a[i + 1]、b[j + 1]；
     *
     * 当a[i] == b[j]
     * i = i + 1；j = j + 1，距离 不变，比较a[i + 1]、b[j + 1]。
     *
     * @param a 字符串a
     * @param n 字符串a长度
     * @param b 字符串b
     * @param m 字符串b长度
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/10
     */
    public static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] dp = new int[n][m];

        // 动态规划
        // 特殊处理第一行
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                dp[0][j] = j;
            } else if (j != 0) {
                dp[0][j] = dp[0][j - 1] + 1;
            } else {
                dp[0][j] = 1;
            }
        }
        // 特殊处理第一列
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = i;
            } else if (i != 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = a[i] == b[j] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                if (dp[i - 1][j] + 1 < dp[i][j]) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
                if (dp[i][j - 1] + 1 < dp[i][j]) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    @Test
    public void lwstDPTest() {
        String a = "mitcmu";
        String b = "mtacnu";
        System.out.println(lwstDP(a.toCharArray(), a.length(), b.toCharArray(), b.length()));
    }

    /**
     * 最长公共子串
     *
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(m * n)
     *
     * 当a[i] != b[j]:
     * 1) i = i + 1，公共子串长度 不变，比较a[i + 1]、b[j]；
     * 2) j = j + 1，公共子串长度 不变，比较a[i]、b[j + 1]；
     * 3) i = i + 1，公共子串长度 不变，j = j + 1，比较a[i + 1]、b[j + 1]；
     *
     * 当a[i] == b[j]:
     * i = i + 1，j = j + 1，公共子串长度 +1，比较a[i + 1]、b[j + 1]。
     *
     * @param a 字符串a
     * @param n 字符串a长度
     * @param b 字符串b
     * @param m 字符串b长度
     * @return int
     * @throws
     * @author yinyg
     * @date 2022/7/10
     */
    public static int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];

        // 动态规划
        // 特殊处理第一行
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                maxlcs[0][j] = 1;
            } else if (j != 0) {
                maxlcs[0][j] = maxlcs[0][j - 1];
            }
        }
        // 特殊处理第一列
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                maxlcs[i][0] = 1;
            } else if (i != 0) {
                maxlcs[i][0] = maxlcs[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                maxlcs[i][j] = a[i] == b[j] ? maxlcs[i - 1][j - 1] + 1 : maxlcs[i - 1][j - 1];
                if (maxlcs[i - 1][j] > maxlcs[i][j]) {
                    maxlcs[i][j] = maxlcs[i - 1][j];
                }
                if (maxlcs[i][j - 1] > maxlcs[i][j]) {
                    maxlcs[i][j] = maxlcs[i][j - 1];
                }
            }
        }

        return maxlcs[n - 1][m - 1];
    }

    @Test
    public void lcsTest() {
        String a = "mitcmu";
        String b = "mtacnu";
        System.out.println(lcs(a.toCharArray(), a.length(), b.toCharArray(), b.length()));
    }

}
