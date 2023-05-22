package com.offer.mid;

/**
 * @author Basil
 * @create 2022/3/25 19:54
 *
 * 深/广度优先遍历
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
    }

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }
}
