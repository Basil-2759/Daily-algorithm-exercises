package com.offer.mid.binarySearch;

/**
 * @author Basil
 * @create 2022/12/16 20:18
 * @description 剑指 Offer 44. 数字序列中某一位的数字
 */
public class DigitOfDigitInSequence {
    public static void main(String[] args) {
        System.out.println(findNthDigit(2901));
    }

    public static int findNthDigit(int n) {
        // n所属数字的位数
        int digit = 1;
        // 数字范围开始的第一个数
        long start = 1;
        // 占多少位
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        // n所属的整数
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
