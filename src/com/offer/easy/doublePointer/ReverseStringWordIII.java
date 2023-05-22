package com.offer.easy.doublePointer;

/**
 * @author Basil
 * @create 2022/3/7 9:27
 *
 * 双指针
 */
public class ReverseStringWordIII {
    public static void main(String[] args) {
        ReverseStringWordIII reverseStringWordIII = new ReverseStringWordIII();
        System.out.println(reverseStringWordIII.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(new StringBuffer(str).reverse());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
