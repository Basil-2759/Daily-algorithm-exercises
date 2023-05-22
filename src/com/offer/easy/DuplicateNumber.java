package com.offer.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Basil
 * @description 剑指 Offer 03. 数组中重复的数字
 * @note 此题拥有多种变种，可参考此题评论区
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println(new DuplicateNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
