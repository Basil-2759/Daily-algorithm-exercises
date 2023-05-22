package com.offer.easy;

/**
 * @author Basil
 * @create 2022/3/6 10:29
 */
public class MoveZero {
    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
