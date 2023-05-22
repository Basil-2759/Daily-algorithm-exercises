package com.offer.easy.arraylist;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/8/6 19:47
 * @title 75. 颜色分类
 * @notes 双指针：设置两个指针head与tail，遍历数组时分别与0和2调换，每次调换后都向中间移动一位，直到遍历的下标大于等于tail时结束
 */
public class ColorClassification {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,2,0,1,2};
        new ColorClassification().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1, temp;
        for (int i = 0; i <= tail; i++) {
            while (i <= tail && nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[tail];
                nums[tail] = temp;
                tail--;
            }
            if (nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[head];
                nums[head] = temp;
                head++;
            }
        }
    }
}
