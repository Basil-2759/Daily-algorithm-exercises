package com.offer.easy.arraylist;

/**
 * @author Basil
 * @create 2022/7/31 14:44
 * @title 169. 多数元素
 * @notes
 */
public class MajorityCalculate {
    public static void main(String[] args) {
        System.out.println(new MajorityCalculate().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        int count = 0, num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]){
                count--;
                if (count < 0){
                    num = nums[i];
                    count = 0;
                }
            }else {
                count++;
            }
        }

        return num;
    }
}
