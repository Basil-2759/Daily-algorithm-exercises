package com.offer.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Basil
 * @create 2022/11/5 18:31
 * @description  根据字符出现频率排序
 */
public class SortByStringFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int frequency = map.get(c);
            sb.append(String.valueOf(c).repeat(Math.max(0, frequency)));
        }
        return sb.toString();
    }
}
