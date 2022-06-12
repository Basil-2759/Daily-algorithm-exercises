package com.offer.easy;

public class OneInBaniry {
    public static void main(String[] args) {
        OneInBaniry oneInBaniry=new OneInBaniry();
        System.out.println(oneInBaniry.hammingWeight(8));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
