package com.offer.mid.binarySearch;

/**
 * @author Basil
 * @create 2022/3/20 10:16
 *
 * 二分查找
 */
public class SearchSpinMinimum {
    public static void main(String[] args) {
        SearchSpinMinimum searchSpinMinimum = new SearchSpinMinimum();
        System.out.println(searchSpinMinimum.findMin(new int[]{3,4,5,1,2}));
        System.out.println(searchSpinMinimum.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(searchSpinMinimum.findMin(new int[]{11,13,15,17}));
        System.out.println(searchSpinMinimum.findMin(new int[]{3, 1, 2}));
    }

    public int findMin(int[] nums) {
        int ans = nums[0], l = nums.length, left = 0, right = l - 1;
        while (left < right){
            int mid = left + ((right - left) / 2);
            if (nums[mid] < nums[right]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        ans = Math.min(ans, nums[left]);
        return ans;
    }
}
