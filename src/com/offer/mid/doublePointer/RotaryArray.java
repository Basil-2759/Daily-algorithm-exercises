package com.offer.mid.doublePointer;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/3/5 10:35
 * <p>
 * 双指针
 */
public class RotaryArray {
    public static void main(String[] args) {
        RotaryArray rotaryArray = new RotaryArray();
        rotaryArray.rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public void rotate(int[] nums, int k) {
        int pos = 0;
        for (int j = nums.length - k; j <= nums.length - 1; j++) {
            nums[pos] = nums[j];
            pos++;
        }
        for (int i = 0; i < nums.length - k; i++) {
            nums[pos] = nums[i];
            pos++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
