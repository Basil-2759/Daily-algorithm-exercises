package com.offer.mid.bitOperation;

/**
 * @author Basil
 * @create 2022/12/7 19:21
 * @description 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @note 有限状态机
 */
public class NumberOfOccurrencesII {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3, 4, 3, 3}));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
