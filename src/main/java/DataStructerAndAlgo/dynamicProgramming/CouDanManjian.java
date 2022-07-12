package DataStructerAndAlgo.dynamicProgramming;

import java.util.Arrays;

/**
 * 凑单满减问题
 * 满200减50，要求满足满减条件，并最大程度的接近200，最大限度的薅羊毛
 *
 * @author yinyg
 * @date 2022/7/6
 */
public class CouDanManjian {

    /**
     * 凑单满减算法
     *
     * @param products 购物车商品
     * @param n 商品数量
     * @param w 满减条件
     * @throws
     * @author yinyg
     * @date 2022/7/6
     */
    public static void bestManjian(int[] products, int n, int w) {
        // 超过3倍，就没有薅羊毛的意义了
        int max = 3 * w;
        boolean[][] states = new boolean[n][max + 1];

        // 动态规划
        // 特殊处理第一行
        states[0][0] = true;
        if (products[0] <= max) {
            states[0][products[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            // 不购买第i件商品
            for (int j = 0; j <= max; j++) {
                if (states[i- 1][j]) {
                    states[i][j] = true;
                }
            }
            // 购买第i件商品
            for (int j = 0; j <= max - products[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + products[i]] = true;
                }
            }
        }

        // 寻找满足满减的最小值
        int j = w;
        int lastLine = n - 1;
        for ( ; j <= max; j++) {
            if (states[lastLine][j]) {
                break;
            }
        }
        System.out.printf("商品: %s%n", Arrays.toString(products));
        if (j == max + 1) {
            System.out.println("无有意义薅羊毛的最优组合");
            return;
        }
        System.out.printf("最优购买组合的商品总金额: %d%n", j);
        // 寻找购买的商品
        System.out.print("购买的商品:");
        for (int i = n - 1; i > 0; i--) {
            if (j - products[i] >= 0 && states[i - 1][j - products[i]]) {
                j -= products[i];
                System.out.printf(" %d", products[i]);
            }
        }
        if (j > 0) {
            System.out.printf(" %d", products[0]);
        }
    }

    public static void main(String[] args) {
        int[] products = new int[]{50, 5, 20, 50, 40, 50, 10};
        bestManjian(products, products.length, 200);
    }

}
