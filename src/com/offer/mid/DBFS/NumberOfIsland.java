package com.offer.mid.DBFS;

/**
 * @author Basil
 * @create 2022/3/25 14:00
 * <p>
 * 深/广度优先遍历
 */
public class NumberOfIsland {
    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println(numberOfIsland.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        }));
    }

    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
