package com.offer.easy;

import java.util.Arrays;

/**
 * @author Basil
 * @description 剑指 Offer 40. 最小的k个数
 */
public class MinK {
    public static void main(String[] args) {
        MinK minK = new MinK();
        int[] arr = {1, 1, 2, 3, 3, 4, 5};
        int k = 3;
        for (int i = 0; i < k; i++) {
            System.out.println(minK.getLeastNumbers(arr, k)[i]);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] aws = new int[k];
        System.arraycopy(arr, 0, aws, 0, k);
        return aws;
    }
}
