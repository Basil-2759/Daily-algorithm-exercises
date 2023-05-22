package com.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Basil
 * @create 2022/5/19 9:20
 */
public class MapRoad {
    static byte[][] map = {
            {11, 12, 15, 18, 20},
            {16, 20, 20, 20, 21},
            {15, 20, 25, 20, 23},
            {14, 20, 20, 20, 24},
            {13, 20, 25, 20, 29}
    };

    /**
     * 四个方向
     */
    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {1, -1, 0, 0};

    /**
     * 查找最优路径
     *
     * @param map      地形数据
     * @param start    起始点
     * @param end      结束点
     * @param stepDrop 单步落差
     * @return
     */
    public static List<List<Point>> findPath(byte[][] map, Point start, Point end, byte stepDrop) {
        int xLength = map.length, yLength = map[0].length, minLength = Integer.MAX_VALUE;
        //走过的路径
        boolean[][] flag = new boolean[xLength][yLength];
        flag[start.x][start.y] = true;
        //全部答案
        List<List<Point>> ans = new ArrayList<>();
        //筛选最短路径后的答案
        List<List<Point>> answer = new ArrayList<>();
        //每一条路径用栈的形式存储
        Deque<Point> stack = new ArrayDeque<>();
        calculatePath(xLength, yLength, start, end, stepDrop, flag, stack, ans);
        //计算最短路径
        for (List<Point> an : ans) {
            minLength = Math.min(minLength, an.size());
        }
        for (List<Point> an : ans) {
            if (an.size() == minLength) {
                answer.add(an);
            }
        }
        return answer;
    }

    public static void calculatePath(int xLength,
                                     int yLength,
                                     Point point,
                                     Point end,
                                     byte stepDrop,
                                     boolean[][] flag,
                                     Deque<Point> stack,
                                     List<List<Point>> ans) {
        stack.offerLast(point);
        //终结循环的条件——找到终点
        if (point.x == end.x && point.y == end.y) {
            ans.add(new ArrayList<>(stack));
            stack.pollLast();
            return;
        }
        flag[point.x][point.y] = true;
        for (int i = 0; i < 4; i++) {
            Point next = new Point(point.x + dirX[i], point.y + dirY[i]);
            //判断：是否出界、是否是未经过的道路、是否小于等于最大落差
            if (next.x < xLength && next.x >= 0 && next.y < yLength && next.y >= 0 && !flag[next.x][next.y] && Math.abs(map[point.x][point.y] - map[next.x][next.y]) <= stepDrop) {
                calculatePath(xLength, yLength, next, end, stepDrop, flag, stack, ans);
            }
        }
        stack.pollLast();
        flag[point.x][point.y] = false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) {
        byte stepDrop = 5;
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);
        List<List<Point>> paths = findPath(map, start, end, stepDrop);
        assert paths != null;
        for (List<Point> path : paths) {
            System.out.println(path);
        }
    }

}
