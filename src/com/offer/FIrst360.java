package com.offer;

import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/4/16 16:02
 */
public class FIrst360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        String[] s = sc2.nextLine().split(" ");
        int[] points = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            points[i] = Integer.parseInt(s[i]);
        }
        int ans = 1;
        for (int i = 1; i < num; i++) {
            if (points[i] > points[i - 1]) {
                ans++;
            }
        }
        sc.close();
        sc.close();
        System.out.println(ans);
    }
}
