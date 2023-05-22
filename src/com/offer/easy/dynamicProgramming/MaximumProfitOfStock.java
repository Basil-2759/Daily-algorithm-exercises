package com.offer.easy.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/11/23 18:46
 * @description 剑指 Offer 63. 股票的最大利润
 * @note 在遍历数组的过程中，维护一个最小值，最小值初试为prices[0]
 *      如果prices[i]大于min，则去更新一下利润res
 *      否则说明当前的prices[i]比min还小，则更新min
 */
public class MaximumProfitOfStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}
