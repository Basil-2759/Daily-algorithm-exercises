package com.offer.mid.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Basil
 * @create 2022/3/9 19:09
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串 - 与此题相同 - 3. 无重复字符的最长子串
 */
public class NoRepeatString {
    public static void main(String[] args) {
        NoRepeatString noRepeatString = new NoRepeatString();
        System.out.println(noRepeatString.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1
        // 相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = -1, ans = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(left - 1));
            }
            while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(right + 1));
                ++right;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
