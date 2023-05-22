package com.offer.easy.arraylist;

/**
 * @author Basil
 * @create 2022/7/31 14:18
 * @title 136. 只出现一次的数字
 * @notes 位运算：异或。因为异或满足交换律和结合律，所以只要将数组中所有的数做异或操作，则相同的都变成0，只剩下单独出现的那一个数。
 */
public class AppearOnceNumber {
    public static void main(String[] args) {
        System.out.println(new AppearOnceNumber().singleNumber(new int[]{4,1,2,1,2}));
    }

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
