package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/28 17:34
 * <p>
 * 递归/回溯
 */
public class SubsetII {
    public static void main(String[] args) {
        SubsetII subsetII = new SubsetII();
        System.out.println(subsetII.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(false, 0, nums, t, ans);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums, List<Integer> t, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        dfs(false, cur + 1, nums, t, ans);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums, t, ans);
        t.remove(t.size() - 1);
    }
}
