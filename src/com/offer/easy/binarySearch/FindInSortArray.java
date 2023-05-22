package com.offer.easy.binarySearch;

/**
 * @author Basil
 * @create 2022/11/19 22:27
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class FindInSortArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public static int search(int[] nums, int target) {
        int length = nums.length, left = 0, right = length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 找到目标数字之后，不断去压缩空间，寻找两个边界值，以便计算答案
                if (nums[right] != target) {
                    right--;
                } else if (nums[left] != target) {
                    left++;
                } else {
                    break;
                }
            }
        }

        return right - left + 1;
    }
}
