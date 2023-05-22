package com.offer.mid.dynamicProgramming;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/12/16 21:23
 * @description 剑指 Offer 60. n个骰子的点数
 */
public class PointsOfDice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
