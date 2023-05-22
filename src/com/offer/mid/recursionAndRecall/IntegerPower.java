package com.offer.mid.recursionAndRecall;

/**
 * @author Basil
 * @description 剑指 Offer 16. 数值的整数次方
 * @note 
 */
public class IntegerPower {
    public static void main(String[] args) {
        IntegerPower integerPower = new IntegerPower();
        System.out.println(integerPower.myPow(0.00001, 2147483647));
        System.out.println(integerPower.myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    public double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
