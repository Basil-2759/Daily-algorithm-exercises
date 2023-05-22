package com.huawei.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Basil
 * @create 2022/9/3 11:24
 * @title HJ4 字符串分隔
 */
public class StringSplit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        int add = 8 - sb.length() % 8;
        while (add > 0 && add < 8) {
            sb.append("0");
            add--;
        }
        String ans = sb.toString();
        while (ans.length() > 0){
            System.out.println(ans.substring(0, 8));
            ans = ans.substring(8);
        }
    }
}
