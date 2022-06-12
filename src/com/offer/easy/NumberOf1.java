package com.offer.easy;

/**
 * @author Basil
 * @create 2022/3/17 11:19
 *
 * 幂运算
 */
public class NumberOf1 {
    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.println(numberOf1.hammingWeight(11));
    }
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
