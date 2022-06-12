package com.offer;

/**
 * @author Basil
 * @create 2022/4/11 20:01
 */
public class QiAnXInSecond {
    public static void main(String[] args) {
        QiAnXInSecond qiAnXInSecond = new QiAnXInSecond();
        System.out.println(qiAnXInSecond.GiveChargeSum(37));
    }

    public int GiveChargeSum (int N) {
        int[] coins = new int[]{1, 2, 5, 10};
        int[] dp = new int[N];
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            for (int coin : coins) {
                if (coin < i){
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[N-1];
    }
}
