package com.huawei.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Basil
 * @create 2022/9/3 10:09
 * @title HJ2 计算某字符出现次数
 */
public class CountCharAppearTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = (char) br.read();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(c))) {
                ans++;
            }
        }

        System.out.println(ans);
    }


}
