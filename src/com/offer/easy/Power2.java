package com.offer.easy;

/**
 * @author Basil
 * @create 2022/3/17 10:36
 */
public class Power2 {
    public static void main(String[] args) {
        Power2 power2 = new Power2();
        System.out.println(power2.isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
