package com.offer.easy;

import java.util.Objects;

/**
 * @author Basil
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 */
public class FirstOneString {
    public static void main(String[] args) {
        FirstOneString firstOneString = new FirstOneString();
        String s = "abccaadef";
        System.out.println(firstOneString.firstUniqChar(s));
        System.out.println('d' - 'a');
    }

    public char firstUniqChar(String s) {
        if (Objects.equals(s, "")) {
            return ' ';
        }
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
