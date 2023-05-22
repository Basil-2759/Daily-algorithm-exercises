package com.offer.easy.mathQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Basil
 * @create 2022/12/9 21:27
 * @description 剑指 Offer 57 - II. 和为s的连续正数序列
 * @note 此题亦可用双指针解决
 */
public class AndAreConsecutivePositiveNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        // (target - 1) / 2 等效于 target / 2 下取整
        int limit = (target - 1) / 2;
        for (int x = 1; x <= limit; ++x) {
            // b² - 4ac
            long delta = 1 - 4 * (x - (long) x * x - 2L * target);
            if (delta < 0) {
                continue;
            }
            int deltaSqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) deltaSqrt * deltaSqrt == delta && (deltaSqrt - 1) % 2 == 0) {
                // 另一个解(-1-deltaSqrt)/2必然小于0，不用考虑
                int y = (-1 + deltaSqrt) / 2;
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
