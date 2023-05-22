package com.offer.mid.arraylist;

/**
 * @author Basil
 * @create 2022/8/16 14:58
 * @title 334. 递增的三元子序列
 * @notes 贪心算法。维护两个变量 first 和 second，根据遍历到的元素的大小关系，找到结果
 */
public class SequenceOfConsecutiveTriadicSubunits {
    public static void main(String[] args) {

    }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                //替换
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
