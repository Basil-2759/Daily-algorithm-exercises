package com.offer.mid.stackAndQueue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Basil
 * @create 2022/8/22 8:24
 * @title 973. 最接近原点的 K 个点
 * @notes
 */
public class ClosestOriginK {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, k);
    }
}
