package com.offer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/12/6 19:04
 * @description com.offer Algorithm
 */
public class RuiLiang {
    public static void main(String[] args) {
//        System.out.println(cToJava("hello_world"));
//        System.out.println(compare("1.1", "-1.1"));
        buyBook();
    }

    public static int compare (String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int ans = v1.length > v2.length ? 1 : -1;
        if (v1.length == v2.length){
            ans = 0;
        }
        int length = Math.min(v1.length, v2.length);
        for (int i = 0; i < length; i++){
            int i1 = Integer.parseInt(v1[i]);
            int i2 = Integer.parseInt(v2[i]);
            if (i1 < 0 || i2 < 0){
                return 0;
            }
            if (i1 > i2){
                return 1;
            }else if (i1 < i2){
                return -1;
            }
        }

        return ans;
    }

    public static String cToJava(String s){
        char[] words = new char[]{'A', 'B', 'C', 'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String[] strings = s.split("_");
        StringBuilder ans = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(strings[i]);
            char big = words[stringBuilder.charAt(0)];
            stringBuilder.replace(0, 0, String.valueOf(big));
            ans.append(stringBuilder);
        }

        return ans.toString();
    }

    public static void buyBook(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HashMap<Integer,String> map = new HashMap<>(num);
        for (int i = 0; i < num; i++) {
            int i1 = Integer.parseInt(sc.next());
            map.put(i1, sc.next());
        }
        List<Integer> list = (List<Integer>) map.keySet();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) < list.get(j)){

                }
            }
        }
    }
}
