package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/28 17:49
 *
 * 递归/溯回
 */
public class FullArrayII {
    public static void main(String[] args) {
        FullArrayII fullArrayII = new FullArrayII();
        System.out.println(fullArrayII.permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm, vis);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm, boolean[] vis) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm, vis);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
