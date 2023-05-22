package com.offer.mid.DBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/28 16:43
 *
 * 深/广度优先遍历
 */
public class AllPossiblePath {
    public static void main(String[] args) {
        AllPossiblePath allPossiblePath = new AllPossiblePath();
        System.out.println(allPossiblePath.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        //从0号点出发，使用栈记录路径上的点
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1, ans, stack);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n, List<List<Integer>> ans, Deque<Integer> stack) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n, ans, stack);
            stack.pollLast();
        }
    }
}
