package com.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Basil
 * @create 2022/4/9 16:54
 */
public class GibitSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add(sc.nextInt());
            }
            path.add(list);
        }

        //存储仙境编号
        Set set = new HashSet();
        boolean[] find = new boolean[m];
        //找最短路径
        int min = path.get(0).get(2), i;
        for (i = 1; i < path.size(); i++) {
            if (min < path.get(i).get(2)){
                min = path.get(i).get(2);
            }
        }
        set.add(path.get(i).get(0));
        set.add(path.get(i).get(1));
        path.remove(i);
        find[i] = false;
        for (int j = 2; j <= m; j++) {
            int min2 = path.get(0).get(0);
            for (int k = 1; k < path.size(); k++) {
                    min2 = path.get(k).get(0) < min2 ? path.get(k).get(0) : min2;
            }
        }

        System.out.println(-1);
    }
}
