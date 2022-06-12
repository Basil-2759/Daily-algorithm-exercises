package com.offer.mid.slidingWindow;

/**
 * @author Basil
 * @create 2022/3/24 20:28
 *
 * 滑动窗口
 */
public class LongestSonArray {
    public static void main(String[] args) {
        LongestSonArray longestSonArray = new LongestSonArray();
        System.out.println(longestSonArray.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(longestSonArray.minSubArrayLen(11, new int[]{1,1,1,1,1,1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;

        }
        return ans== Integer.MAX_VALUE ? 0 : ans;
    }
}
