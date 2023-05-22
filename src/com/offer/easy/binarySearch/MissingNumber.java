package com.offer.easy.binarySearch;

/**
 * @author Basil
 * @create 2022/11/19 22:09
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @note 将数组分为左右两个子数组，左面为对的，右面则是由于缺失而导致对不上号的，用二分查找即可分出来
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length, left = 0, right = length - 1;
        while (left < right){
            int mid = (right + left) / 2;
            if (mid == nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        // 如果从0 ~ n - 1都不缺值, 则缺少的是n
        return left == length - 1 && nums[left] == left ? left + 1 : left;
    }
}
