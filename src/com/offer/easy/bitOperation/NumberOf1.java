package com.offer.easy.bitOperation;

/**
 * @author Basil
 * @create 2022/3/17 11:19
 * @description 剑指 Offer 15. 二进制中1的个数
 * @note 一、当检查第 i 位时，我们可以让 n 与 2^i 进行与运算，当且仅当 n 的第 i 位为 1 时，运算结果不为 0。
 * 二、n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果
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
    public static int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
