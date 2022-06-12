package com.offer.mid;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Basil
 * @create 2022/4/7 8:56
 */
public class ScramblingArray {
    int[] nums;
    int[] original;

    public ScramblingArray(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original,0, nums, 0, original.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        ScramblingArray scramblingArray = new ScramblingArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(scramblingArray.shuffle()));
        System.out.println(Arrays.toString(scramblingArray.reset()));
        System.out.println(Arrays.toString(scramblingArray.shuffle()));
    }
}
