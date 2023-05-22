package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/4/2 19:26
 * @description 91.解码方法(动态规划)
 */
public class DecodingMethod {
    public static void main(String[] args) {
        DecodingMethod decodingMethod = new DecodingMethod();
        System.out.println(decodingMethod.numDecodings("12"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
