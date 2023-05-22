package com.offer.mid.recursionAndRecall;

/**
 * @author Basil
 * @create 2022/12/4 21:21
 * @description 剑指 Offer 64. 求1+2+…+n
 */
public class Find1Add2AddN {
    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
