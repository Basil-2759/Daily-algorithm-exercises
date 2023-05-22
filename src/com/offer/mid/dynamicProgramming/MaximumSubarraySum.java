package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/11/8 11:13
 * @description 最大子数组和
 */
public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -1, 9, 9, 9, -1, 9, -2, -3}));
    }

    public static int maxSubArray(int[] nums) {
        int answer = nums[0], sum = 0;
        for (int num : nums) {
            //  假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；如果sum > 0对于后面的子序列是有好处的。
            //  res = Math.max(res, sum)保证可以找到最大的子序和。
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
