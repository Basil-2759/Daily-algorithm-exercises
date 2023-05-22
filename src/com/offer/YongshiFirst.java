package com.offer;

import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/4/28 20:08
 */
public class YongshiFirst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //截取version后面面的部分
        String version1 = in.nextLine().split("=")[1];
        String version2 = in.nextLine().split("=")[1];
        String[] charVersion1 = version1.split(" ");
        String[] charVersion2 = version2.split(" ");
        //筛选是否存在空格
        if (charVersion1.length > 1){
            charVersion1 = charVersion1[1].split("\\.");
            charVersion2 = charVersion2[1].split("\\.");
        }else {
            charVersion1 = charVersion1[0].split("\\.");
            charVersion2 = charVersion2[0].split("\\.");
        }
        int i = 0, ans = 0, l = charVersion1.length;
        for (int j = 0; j < l; j++) {
            if (Integer.parseInt(charVersion1[i]) != Integer.parseInt(charVersion2[i])) {
                break;
            }
        }
        if (Integer.parseInt(charVersion1[i + 1]) > Integer.parseInt(charVersion2[i + 1])) {
            ans = 1;
        } else if (Integer.parseInt(charVersion1[i + 1]) < Integer.parseInt(charVersion2[i + 1])) {
            ans = -1;
        }

        System.out.println(ans);
    }
}
