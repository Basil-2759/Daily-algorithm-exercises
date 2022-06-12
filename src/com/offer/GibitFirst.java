package com.offer;

import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/4/9 16:38
 */
public class GibitFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] mark = new int[6];

            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '('){
                    mark[0]++;
                }
                if (str.charAt(j) == ')'){
                    mark[1]++;
                }
                if (str.charAt(j) == '['){
                    mark[2]++;
                }
                if (str.charAt(j) == ']'){
                    mark[3]++;
                }
                if (str.charAt(j) == '{'){
                    mark[4]++;
                }
                if (str.charAt(j) == '}'){
                    mark[5]++;
                }
            }
            if (mark[0] == mark[1] && mark[2] == mark[3] && mark[4] == mark[5]){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
