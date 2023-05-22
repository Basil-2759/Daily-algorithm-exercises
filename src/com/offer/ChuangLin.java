package com.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Basil
 * @create 2022/12/8 16:36
 * @description com.offer Algorithm
 */
public class ChuangLin {
    public static void main(String[] args) {
//        System.out.println(one(new int[]{1, 3, 4, 5, 6}, new int[]{2, 5, 7, 8, 9}));
//        System.out.println(one(new int[]{}, new int[]{2, 5, 7, 8, 9}));
//        System.out.println(one(new int[]{1}, new int[]{2, 5, 7, 8, 9}));
//        System.out.println(one(new int[]{}, new int[]{}));
//        System.out.println(one(null, null));

        System.out.println(two(new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        System.out.println(two(new int[][]{{0, 1}, {0, 3}, {0, 4}, {1, 2},{1,3},{1,4},{2,3},{3,4}}));
    }

    public static List<Integer> one(int[] a, int[] b) {
        if (a == null || b == null) {
            return null;
        }
        int i = 0, j = 0, al = a.length, bl = b.length;
        List<Integer> ans = new ArrayList<>();
        while (i < al && j < bl) {
            if (a[i] < b[j]) {
                ans.add(a[i]);
                i++;
            } else {
                ans.add(b[j]);
                j++;
            }
        }
        if (i == a.length) {
            for (int k = j; k < bl; k++) {
                ans.add(b[k]);
            }
        } else if (j == b.length) {
            for (int k = i; k < al; k++) {
                ans.add(a[k]);
            }
        }

        return ans;
    }

    public static List<List<Integer>> two(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = 0;
        for (int[] ints : graph) {
            for (int j = 0; j < 2; j++) {
                n = Math.max(n, ints[j]);
            }
        }
        stack.offerLast(0);
        dfs(graph, 0, n, ans, stack);
        return ans;
    }

    public static void dfs(int[][] graph, int x, int n, List<List<Integer>> ans, Deque<Integer> stack) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int[] arr : graph) {
            if (arr[0] == x) {
                stack.offerLast(arr[1]);
                dfs(graph, arr[1], n, ans, stack);
                stack.pollLast();
            }
        }
    }
}
