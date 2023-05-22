package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/28 17:02
 * @description 78. 子集(递归/回溯)
 */
public class Subset {
    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sub(nums, 0, ans, list);
        return ans;
    }

    public void sub(int[] nums, int i, List<List<Integer>> ans, List<Integer> list) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        sub(nums, i+1, ans, list);
        list.remove(list.size() - 1);
        sub(nums, i+1, ans, list);
    }
}
