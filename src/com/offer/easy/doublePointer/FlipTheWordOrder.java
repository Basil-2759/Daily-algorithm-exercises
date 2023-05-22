package com.offer.easy.doublePointer;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/11/28 21:21
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 */
public class FlipTheWordOrder {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue!"));
        System.out.println(reverseWords2("the sky is blue!"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        int left = 0, right = strings.length - 1;
        while (left < right) {
            String flag = strings[left];
            strings[left] = strings[right];
            strings[right] = flag;
            left++;
            right--;
        }

        return  Arrays.toString(strings).trim();
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                // 搜索首个空格
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            while(i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }
}
