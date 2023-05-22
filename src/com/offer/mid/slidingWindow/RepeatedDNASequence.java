package com.offer.mid.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Basil
 * @create 2022/11/5 11:53
 * @description 187. 重复的DNA序列
 */
public class RepeatedDNASequence {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    static final int L = 10;

    public static List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String sub = s.substring(i, i + L);
            count.put(sub, count.getOrDefault(sub, 0) + 1);
            if (count.get(sub) == 2) {
                answer.add(sub);
            }
        }

        return answer;
    }
}
