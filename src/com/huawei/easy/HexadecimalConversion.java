package com.huawei.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Basil
 * @create 2022/9/3 15:15
 * @title HJ5 进制转换
 */
public class HexadecimalConversion {
    private final static int BASE = 16;
    private static Map<Character, Integer> map = new HashMap<Character, Integer>()
    {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
        put('a', 10);
        put('b', 11);
        put('c', 12);
        put('d', 13);
        put('e', 14);
        put('f', 15);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = 0;
        for (int l = str.length() - 1; l >= 2; l--) {
            ans += map.get(str.charAt(l)) * Math.pow(BASE, str.length() - 1 - l);
        }

        System.out.println(ans);
    }
}
