package com.offer.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Basil
 * @create 2022/12/3 10:27
 * @description 面试题61. 扑克牌中的顺子
 * @note 排序
 */
public class StraightInPlayingCards {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
    }

    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                // 跳过大小王
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                // 若有重复，提前返回 false
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }
}
