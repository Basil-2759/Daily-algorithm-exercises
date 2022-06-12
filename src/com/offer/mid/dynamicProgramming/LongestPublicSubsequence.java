package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/4/4 19:20
 * <p>
 * 动态规划
 */
public class LongestPublicSubsequence {
    public static void main(String[] args) {
        LongestPublicSubsequence longestPublicSubsequence = new LongestPublicSubsequence();
        System.out.println(longestPublicSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //dp[i][j]表示text[0:i]和text[0:j]的最长公共子序列的长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //两个字母不相等时，要考虑
                    // text[0:i-1]和text[0:j] 或
                    // text[0:i]和text[0:j-1]
                    //其中较大的一项是最长子串
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
