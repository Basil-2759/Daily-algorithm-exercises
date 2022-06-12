package com.offer.easy;

import java.util.Arrays;

public class MinK {
    public static void main(String[] args) {
        MinK minK=new MinK();
        int[] arr={1,1,2,3,3,4,5};
        int k=3;
        for (int i = 0; i < k; i++) {
            System.out.println(minK.getLeastNumbers(arr,k)[i]);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] aws=new int[k];
        for (int i = 0; i < k; i++) {
            aws[i]=arr[i];
        }
        return aws;
    }
}
