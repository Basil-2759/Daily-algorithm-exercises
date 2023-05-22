package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/14 10:31
 * @description 全排列（递归/回溯）
 */
public class WholeArrangement {
    public static void main(String[] args) {
        WholeArrangement wholeArrangement = new WholeArrangement();
        System.out.println(wholeArrangement.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        dfs(ans, output, 0, n);
        return ans;

    }

    public void dfs(List<List<Integer>> ans, List<Integer> output, int begin, int n) {
        if (begin == n){
            ans.add(new ArrayList<>(output));
        }
        for (int i = begin; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, begin, i);
            // 继续递归填下一个数
            dfs(ans, output, begin+1, n);
            // 撤销操作
            Collections.swap(output, begin, i);
        }
    }
}
