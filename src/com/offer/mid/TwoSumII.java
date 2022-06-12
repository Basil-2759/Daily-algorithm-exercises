package com.offer.mid;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/3/6 10:48
 */
public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII twoSumSecond = new TwoSumII();
        System.out.println(Arrays.toString(twoSumSecond.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, left = 0, right = n - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                break;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
