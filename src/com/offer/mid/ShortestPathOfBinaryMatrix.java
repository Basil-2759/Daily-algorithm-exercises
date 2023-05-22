package com.offer.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Basil
 * @create 2022/3/28 15:07
 *
 * 深/广度优先遍历
 */
public class ShortestPathOfBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathOfBinaryMatrix shortestPathOfBinaryMatrix = new ShortestPathOfBinaryMatrix();
        System.out.println(shortestPathOfBinaryMatrix.shortestPathBinaryMatrix(new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        }));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int i = 0, j = 0;
        if (grid[i][j] == 1) {
            return -1;
        }
        //定义 8个方向
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        //bfs的老套路 来个队列
        Queue<int[]> queue = new LinkedList<>();
        //把起点扔进去
        queue.add(new int[]{0, 0});
        // 把起点标记为阻塞
        grid[0][0] = 1;
        // 层数
        int path = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                assert cur != null;
                int x = cur[0];
                int y = cur[1];
                // 能放进队列里的都是为0可以走的（这一点在后面保证了）
                // 如果等于终点则返回
                if (x == m - 1 && y == n - 1) {
                    return path;
                }
                //开始八个方向的判断
                for (int[] d : dir) {
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    //这里开始过滤
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= m || grid[x1][y1] == 1) {
                        continue;
                    }
                    //把在数组范围内 并且为0不阻塞的放入队列中
                    queue.add(new int[]{x1, y1});
                    // 标记
                    grid[x1][y1] = 1;
                }
            }
            //遍历完一层 这时候要 ++啦
            path++;
        }
        return -1;
    }
}
