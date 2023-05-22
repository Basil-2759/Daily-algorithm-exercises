package com.offer.mid.DBFS;

/**
 * @author Basil
 * @create 2022/3/10 10:24
 * <p>
 * 深/广度优先
 */
public class IslandMaxArea {
    public static void main(String[] args) {
        IslandMaxArea islandMaxArea = new IslandMaxArea();
        System.out.println(islandMaxArea.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int aws = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                aws = Math.max(aws, calculateMax(grid, x, y));
            }
        }

        return aws;
    }

    public int calculateMax(int[][] grid, int cur_x, int cur_y){
        if (cur_x < 0 || cur_y < 0 || cur_x == grid.length || cur_y == grid[0].length || grid[cur_x][cur_y] != 1) {
            return 0;
        }

        grid[cur_x][cur_y] = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        //?
        int aws = 1;
        for (int i = 0; i < 4; i++) {
            aws += calculateMax(grid, cur_x+dx[i], cur_y+dy[i]);
        }
        return aws;
    }
}
