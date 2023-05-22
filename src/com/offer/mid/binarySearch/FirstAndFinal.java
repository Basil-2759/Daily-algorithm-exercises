package com.offer.mid.binarySearch;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/3/19 9:42
 * <p>
 * 二分查找
 */
public class FirstAndFinal {
    public static void main(String[] args) {
        FirstAndFinal firstAndFinal = new FirstAndFinal();
        System.out.println(Arrays.toString(firstAndFinal.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        //其实我们要找的就是数组中第一个大于等于target的位置（记为leftIdx）和第一个大于target的位置减一（记为rightIdx）
        int leftIdx = binarySearch(nums, target, true);
        //为方便代码复用，使用lower值表示查找第一个还是最后一个
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
