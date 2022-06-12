package com.offer.mid;

/**
 * @author Basil
 * @create 2022/4/3 14:39
 * <p>
 * 动态规划
 */
public class LongestIncrementalSubsequence {
    public static void main(String[] args) {
        LongestIncrementalSubsequence longestIncrementalSubsequence = new LongestIncrementalSubsequence();
        System.out.println(longestIncrementalSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
