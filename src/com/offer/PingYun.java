package com.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Basil
 * @create 2022/12/13 22:48
 * @description com.offer Algorithm
 */
public class PingYun {
    public static void main(String[] args) {
        System.out.println(twentyThree("ABBCCCCCBBAB"));
        System.out.println(twentyThree("aAC"));
        System.out.println(twentyThree("a"));
        System.out.println(twentyThree(""));
    }

    public static String twentyThree(String string) {
        if (string.length() == 0) {
            return string;
        }
        int left = 0, right = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.charAt(0));
        while (right < string.length()) {
            if (string.charAt(left) != string.charAt(right) && Character.toUpperCase(string.charAt(left)) != string.charAt(right) && Character.toLowerCase(string.charAt(left)) != string.charAt(right)) {
                stringBuilder.append(string.charAt(right));
                left = right;
            }
            right++;
        }

        return stringBuilder.toString();
    }

    public static String[] twentyTwo(int count, int strLength) {
        String[] ans = new String[count];
        Random random = new Random();

        return ans;
    }

    public static String[] twentyTwo(int count) {
        int strLength = 10;
        return twentyTwo(count, 10);
    }
}
