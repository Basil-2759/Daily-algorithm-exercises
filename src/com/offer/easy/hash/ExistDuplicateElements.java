package com.offer.easy.hash;

import java.util.HashSet;

/**
 * @author Basil
 * @create 2022/7/17 20:37
 * @title 217. 存在重复元素
 */
public class ExistDuplicateElements {
    public static void main(String[] args) {
        System.out.println(new ExistDuplicateElements().containsDuplicate(new int[]{7,3,2,1,2}));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
