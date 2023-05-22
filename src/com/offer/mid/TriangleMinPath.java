package com.offer.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/16 9:25
 * <p>
 * 最小路径
 */
public class TriangleMinPath {
    public static void main(String[] args) {
        TriangleMinPath triangleMinPath = new TriangleMinPath();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> one = new ArrayList<Integer>() {{
            add(-1);
        }};
        List<Integer> two = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        List<Integer> three = new ArrayList<Integer>() {{
            add(1);
            add(-1);
            add(-3);
        }};
        List<Integer> four = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
//        triangle.add(four);
        System.out.println(triangleMinPath.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
