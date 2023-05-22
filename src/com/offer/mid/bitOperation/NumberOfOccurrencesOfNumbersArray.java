package com.offer.mid.bitOperation;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/12/7 18:27
 * @description 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class NumberOfOccurrencesOfNumbersArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{4, 1, 4, 6})));
    }

    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
