package com.offer.easy.doublePointer;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/3/5 9:16
 * <p>
 * 双指针
 */
public class ArraySquare {
    public static void main(String[] args) {
        ArraySquare arraySquare = new ArraySquare();
        System.out.println(Arrays.toString(arraySquare.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(arraySquare.sortedSquares2(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(arraySquare.sortedSquares3(new int[]{-7, -3, 2, 3, 11})));
    }

    public int[] sortedSquares(int[] nums) {
        int flag;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    flag = nums[j];
                    nums[j] = nums[i];
                    nums[i] = flag;
                }
            }
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        return nums;
    }

    /**
     * 真正的双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int flag = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                flag = i;
            } else {
                break;
            }
        }

        int i = flag, j = flag + 1, pos = 0;
        int[] aws = new int[nums.length];
        while (i >= 0 || j < aws.length) {
            if (i < 0) {
                aws[pos] = nums[j] * nums[j];
                j++;
            } else if (j == aws.length) {
                aws[pos] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                aws[pos] = nums[i] * nums[i];
                i--;
            } else {
                aws[pos] = nums[j] * nums[j];
                j++;
            }
            pos++;
        }
        return aws;
    }

    /**
     * 将双指针置于数组两侧，比较最大值，倒序填入新数组
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
        int[] aws = new int[nums.length];
        for (int i = 0, j = aws.length - 1, pos = aws.length - 1; i <= j; ) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                aws[pos] = nums[j] * nums[j];
                j--;
            } else {
                aws[pos] = nums[i] * nums[i];
                i++;
            }
            pos--;
        }
        return aws;
    }
}
