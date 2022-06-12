package com.offer.easy;

/**
 * @author Basil
 * @create 2022/3/17 11:32
 */
public class UpsideDown {
    public static void main(String[] args) {
        UpsideDown upsideDown = new UpsideDown();
        System.out.println(upsideDown.reverseBits(-3));
    }

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}