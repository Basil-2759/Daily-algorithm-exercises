package com.offer.mid.arraylist;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Basil
 * @create 2022/8/16 10:45
 * @title 435. 无重叠区间
 * @notes
 */
public class IntervalWithoutOverlap {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,100},{11,22},{1,11},{2,12}
        }));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
