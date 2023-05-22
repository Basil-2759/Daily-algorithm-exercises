package com.offer.easy.mathQuestion;

import java.util.Arrays;

/**
 * @author Basil
 * @description 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @note 摩尔投票
 */
public class OvertakeHalf {
    public static void main(String[] args) {
        OvertakeHalf overtakeHalf = new OvertakeHalf();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(overtakeHalf.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Arrays.sort(nums);
        return nums[half];
    }

    public int majorityElement2(int[] nums) {
        int count = 0, card = 0;
        for (int num : nums) {
            if (count == 0) {
                card = num;
            }
            count += (card == num) ? 1 : -1;
        }
        return card;
    }
}
