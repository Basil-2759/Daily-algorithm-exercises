package com.offer.mid.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/23 16:32
 * <p>
 * 双指针
 */
public class ListIntersection {
    public static void main(String[] args) {
        ListIntersection listIntersection = new ListIntersection();
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(listIntersection.intervalIntersection(firstList, secondList)));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i <firstList.length && j <secondList.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the start point of the intersection
            // hi - the end point of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) {
                ans.add(new int[]{lo, hi});
            }

            // Remove the interval with the smallest end point
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
