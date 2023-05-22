package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/11/24 19:36
 * @description 剑指 Offer 47. 礼物的最大价值
 */
public class MaximumValueOfGift {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int maxValue(int[][] grid) {
        int line = grid.length, row = grid[0].length;
        for (int l = 0; l < line; l++) {
            for (int r = 0; r < row; r++) {
                if (l == 0 && r == 0) {
                    continue;
                }
                if (l == 0) {
                    // 只可从左边到达
                    grid[l][r] += grid[l][r - 1];
                } else if (r == 0) {
                    // 只可从上边到达
                    grid[l][r] += grid[l - 1][r];
                } else {
                    grid[l][r] += Math.max(grid[l][r - 1], grid[l - 1][r]);
                }
            }
        }
        return grid[line - 1][row - 1];
    }
}
