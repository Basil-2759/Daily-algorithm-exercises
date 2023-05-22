package com.offer.mid.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Basil
 * @create 2022/8/11 19:32
 * @title 56. 合并区间
 * @notes 先按照数组左端点的数按照升序排序，然后将第一个数对放入答案中，下一个数对的左端点如果大于等于前一个的右端点，则直接放入，否则将右端点和前一个右端点较大的那一个替换前一个右端点
 */
public class MergeRange {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(new MergeRange().merge(new int[][]{{1, 3}, {2, 6}, {8 ,10}, {15, 18}})));
        System.out.println(Arrays.deepToString(new MergeRange().merge(new int[][]{{1, 4}, {4, 5}})));
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();

        //按照左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        //先把第一个放入答案
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] flag = ans.get(ans.size() - 1);
            //当前数对的左端点大于等于答案中最后一个数对的右端点
            if (intervals[i][0] > flag[1]){
                ans.add(intervals[i]);
            }else {
                //比较二者水大放谁
                ans.set(ans.size() - 1, new int[]{flag[0], Math.max(flag[1], intervals[i][1])});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
