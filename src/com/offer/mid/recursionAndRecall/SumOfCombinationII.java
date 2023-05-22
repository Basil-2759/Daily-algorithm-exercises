package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/28 20:30
 * @description 组合总和 II(递归/溯回)
 */
public class SumOfCombinationII {
    public static void main(String[] args) {
        SumOfCombinationII sumOfCombinationII = new SumOfCombinationII();
        System.out.println(sumOfCombinationII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<int[]> freq = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        combination(target, list, ans, 0, freq);
        return ans;
    }

    public void combination(int target, List<Integer> list, List<List<Integer>> ans, int idx, List<int[]> freq) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx == freq.size() || target < freq.get(idx)[0]) {
            return;
        }
        combination(target, list, ans, idx + 1, freq);
        int most = Math.min(target / freq.get(idx)[0], freq.get(idx)[1]);
        for (int i = 1; i <= most; ++i) {
            list.add(freq.get(idx)[0]);
            combination(target - i * freq.get(idx)[0], list, ans, idx + 1, freq);
        }
        for (int i = 1; i <= most; ++i) {
            list.remove(list.size() - 1);
        }
    }
}
