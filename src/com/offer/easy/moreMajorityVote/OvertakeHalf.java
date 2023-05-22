package com.offer.easy.moreMajorityVote;

import java.util.Arrays;

public class OvertakeHalf {
    public static void main(String[] args) {
        OvertakeHalf overtakeHalf=new OvertakeHalf();
        int[] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(overtakeHalf.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        int half=nums.length/2;
        Arrays.sort(nums);
        return nums[half];
    }

    public int majorityElement2(int[] nums) {
        //摩尔投票
        int count = 0;
        Integer card = null;
        for(int num:nums){
            if(count == 0) card = num;
            count += (card == num)?1:-1;
        }
        return card;
    }
}
