package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/4/3 15:22
 * <p>
 * 动态规划
 */
public class LongestIncreasingNum {
    public static void main(String[] args) {
        LongestIncreasingNum longestIncreasingNum = new LongestIncreasingNum();
        System.out.println(longestIncreasingNum.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, ans = 0;
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        // 重置计数
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                // 重置计数
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
