package com.offer.easy;

public class NumberOfOne {
    public static void main(String[] args) {
        NumberOfOne numberOfOne=new NumberOfOne();
        System.out.println(numberOfOne.hammingWeight(00000000000000000000000000001011));
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
