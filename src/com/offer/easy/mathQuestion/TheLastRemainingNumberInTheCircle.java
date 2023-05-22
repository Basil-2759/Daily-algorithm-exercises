package com.offer.easy.mathQuestion;

/**
 * @author Basil
 * @create 2022/12/9 21:42
 * @description 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class TheLastRemainingNumberInTheCircle {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 1));
    }

    public static int lastRemaining(int n, int m) {
        return dfs(n, m);
    }

    public static int dfs(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = dfs(n - 1, m);
        return (m + x) % n;
    }
}
