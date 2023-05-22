package com.offer.easy.doublePointer;

/**
 * @author Basil
 * @create 2022/11/19 15:36
 * @description 剑指 Offer 58 - II. 左旋转字符串
 */
public class LeftRotatedString {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords2("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static String reverseLeftWords2(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }

    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
