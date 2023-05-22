package com.offer.mid.DBFS;

/**
 * @author Basil
 * @description 面试题13. 机器人的运动范围
 */
public class RobotSports {
    public static void main(String[] args) {
        RobotSports robotSports = new RobotSports();
        int m = 2, n = 3, k = 1;
        System.out.println(robotSports.movingCount(m, n, k));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
    }
}
