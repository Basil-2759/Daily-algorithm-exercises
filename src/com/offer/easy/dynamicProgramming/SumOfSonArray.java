package com.offer.easy.dynamicProgramming;

/**
 * @author Basil
 * @description 剑指 Offer 42. 连续子数组的最大和
 */
public class SumOfSonArray {
    public static void main(String[] args) {
        SumOfSonArray sumOfSonArray = new SumOfSonArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sumOfSonArray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        // dp表示以下标i为结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
