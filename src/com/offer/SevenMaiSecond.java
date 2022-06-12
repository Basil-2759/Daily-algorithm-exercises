package com.offer;

/**
 * @author Basil
 * @create 2022/4/20 16:28
 */
public class SevenMaiSecond {
    public static void main(String[] args) {
        System.out.println(minOperationCount("abd", "bcde"));
    }

    public static int minOperationCount(String source, String target) {
        // 动态规划
        int sorceLength = source.length(), targetLength = target.length();
        // 存储：从source到target的最小操作数，下标代表各自的长度
        int[][] dp = new int[sorceLength + 1][targetLength + 1];
        for (int i = 1; i <= sorceLength; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= targetLength; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= sorceLength; i++) {
            char s = source.charAt(i - 1);
            for (int j = 1; j <= targetLength; j++) {
                char t = target.charAt(j - 1);
                if (s == t) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 状态转移方程：
                    // 相同则不需计算，不相同则等于source+这个字符之前的最小操作数，和target加上这个字符之前的最小操作数，取最小的
                    // 那么再修改一次（也就是操作数+1），则得到当前俩字符串长度下的最小操作数————dp[i][j]
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[sorceLength][targetLength];
    }
}
