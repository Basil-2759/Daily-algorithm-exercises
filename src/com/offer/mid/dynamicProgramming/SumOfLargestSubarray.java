package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/7/17 21:49
 * @title 53. 最大子数组和
 */
public class SumOfLargestSubarray {
    public static void main(String[] args) {
        System.out.println(new SumOfLargestSubarray().maxSubArrayII(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new SumOfLargestSubarray().maxSubArrayII(new int[]{-2}));
        System.out.println(new SumOfLargestSubarray().maxSubArrayII(new int[]{5,4,-1,7,8}));
    }

    public int maxSubArray(int[] nums) {
        int answer = nums[0], sum;
        for (int i = 1; i < nums.length; i++){
            sum = 0;
            for (int j = i; j >= 0; j--){
                sum += nums[j];
                answer = Math.max(sum, answer);
            }
        }

        return answer;
    }

    public int maxSubArrayII(int[] nums) {
        int answer = nums[0], sum = 0;
        for (int num : nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public int maxSubArrayIII(int[] nums) {
        int answer = nums[0], sum = 0;
        for (int num : nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
