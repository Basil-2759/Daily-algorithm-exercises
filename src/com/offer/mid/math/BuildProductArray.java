package com.offer.mid.math;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/12/9 22:18
 * @description 剑指 Offer 66. 构建乘积数组
 * @note 维护两个数组，存储对应索引 i 左右两边的前缀和
 */
public class BuildProductArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(constructArr(new int[]{})));
    }

    public static int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        int length = a.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = a[i - 1] * answer[i - 1];
        }

        // r 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 r = 1
        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 r
            answer[i] = answer[i] * r;
            // r 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 r 上
            r *= a[i];
        }
        return answer;
    }
}
