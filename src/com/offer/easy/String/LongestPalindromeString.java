package com.offer.easy.String;

/**
 * @author Basil
 * @create 2022/8/17 8:52
 * @title 409. 最长回文串
 * @notes 先计数，然后放在回文串两侧，再找中间数
 */
public class LongestPalindromeString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int ans = 0;
        //字符的 ASCII 值的范围为 [0, 128)
        int[] count = new int[128];
        //计数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        for (int v : count) {
            //整除后再×2即是回文串要用的长度
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0){
                //如果此时的字母为奇数，且当前回文串为偶数，就可以把一个数放在中间，这是因为回文串只能包含一个中间数
                ans++;
            }
        }

        return ans;
    }
}
