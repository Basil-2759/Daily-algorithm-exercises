package com.offer.mid.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/8/17 15:21
 * @title 763. 划分字母区间
 * @notes 贪心算法
 */
public class DelimitLetterIntervals {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //记录最后出现的下标
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
