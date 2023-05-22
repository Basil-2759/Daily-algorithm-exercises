package com.offer.mid.arraylist;

import java.util.HashMap;

/**
 * @author Basil
 * @create 2022/8/16 15:30
 * @title 560. 和为 K 的子数组
 * @notes
 */
public class AndOfSubarrayOfK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
