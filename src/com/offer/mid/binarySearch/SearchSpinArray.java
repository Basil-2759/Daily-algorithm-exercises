package com.offer.mid.binarySearch;

/**
 * @author Basil
 * @create 2022/3/19 10:46
 * @description 二分查找
 */
public class SearchSpinArray {
    public static void main(String[] args) {
        SearchSpinArray searchSpinArray = new SearchSpinArray();
        System.out.println(searchSpinArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    /**
     * 可以发现的是，我们将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
