package com.offer.easy.binarySearch;

/**
 * @author Basil
 * @create 2022/3/4 15:48
 *
 * 二分查找
 */
public class SearchLocation {
    public static void main(String[] args) {
        SearchLocation searchLocation = new SearchLocation();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;
        System.out.println(searchLocation.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right + 1;

    }
}
