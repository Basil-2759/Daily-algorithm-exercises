package com.offer.hard.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/12/21 10:45
 * @description 剑指 Offer 43. 1～n 整数中 1 出现的次数
 */
public class NumberOfOccurrencesOfIntegerOne {
    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }

    /**
     * mulk 表示 10^k
     * 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
     * 但为了让代码看起来更加直观，这里保留了 k
     */
    public static int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
