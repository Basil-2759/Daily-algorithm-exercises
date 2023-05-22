package com.offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Basil
 * @create 2022/11/3 20:19
 * @description 写一个程序，实现对数组[2,1,9,5,4,6,5,1,2,8,13,9]排序和去重，输出[1,2,4,5,6,8,9,13]
 */
public class XiShiDuo {
    public static void main(String[] args) {
        sortAndDistinct(new int[]{2,1,9,5,4,6,5,1,2,8,13,9});
    }

    public static void sortAndDistinct(int[] num){
        int length = num.length;
        for (int j = 0; j < length; j++){
            for (int i = 0; i < length - 1; i++){
                if (num[i] > num[i + 1]){
                    int flag = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = flag;
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int n : num){
            set.add(n);
        }
        System.out.println(set);
    }
}
