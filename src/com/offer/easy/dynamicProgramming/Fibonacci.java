package com.offer.easy.dynamicProgramming;

/**
 * @author Basil
 * @description 剑指 Offer 10- I. 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n == 1 || n == 0) {
            return n;
        } else {
            int[] arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
            }
            return arr[n];
        }
    }
}
