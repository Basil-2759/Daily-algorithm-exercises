package com.offer.easy.bitOperation;

/**
 * @author Basil
 * @create 2022/12/6 21:05
 * @description 剑指 Offer 65. 不用加减乘除做加法
 */
public class SpecialAdd {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
