package com.offer.easy;

/**
 * @author Basil
 * @create 2022/3/17 11:35
 *
 */
public class OnlyAppearOnce {
    public static void main(String[] args) {
        OnlyAppearOnce onlyAppearOnce = new OnlyAppearOnce();
        System.out.println(onlyAppearOnce.singleNumber(new int[]{4,1,2,1,2}));
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
