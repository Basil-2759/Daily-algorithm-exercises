package com.offer.easy;

import java.util.Arrays;

/**
 * @author Basil
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 */
public class From1ToN {
    public static void main(String[] args) {
        From1ToN from1ToN = new From1ToN();
        int[] k = from1ToN.printNumbers(2);
        System.out.println(Arrays.toString(k));
    }

    public int[] printNumbers(int n) {
        // m用来计算最大的n位数，j辅助计算
        int m = 0, j = 1;

        for (int i = 0; i < n; i++) {
            m = m + 9 * j;
            j *= 10;
        }

        int[] aws = new int[m];
        for (int i = 0; i < m; i++) {
            aws[i] = i + 1;
        }
        return aws;
    }
}
