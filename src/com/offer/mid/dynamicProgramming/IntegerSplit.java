package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/4/5 14:23
 * <p>
 * 动态规划
 */
public class IntegerSplit {
    public static void main(String[] args) {
        IntegerSplit integerSplit = new IntegerSplit();
        System.out.println(integerSplit.integerBreak(2));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
