package com.offer.easy.doublePointer;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/11/28 21:12
 * @description 剑指 Offer 57. 和为s的两个数字
 * @note 也可以用二分查找
 */
public class SisTwoNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
