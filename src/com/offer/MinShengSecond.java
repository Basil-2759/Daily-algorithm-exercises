package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/4/17 16:24
 */
public class MinShengSecond {
    public static void main(String[] args) {
        System.out.println(antiNumber(6));
        System.out.println(antiNumber(10));
    }

    public static int antiNumber(int x){
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        while (x != 1){
            list.add(x % 2);
            x = x / 2;
        }
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(list.size() - i - 1) == 1){
                int jia = 1;
                for (int j = i; j > 0; j--) {
                    jia *= 2;
                }
                ans += jia;
            }
        }
        return ans;
    }
}
