package com.offer.mid.bitOperation;

/**
 * @author Basil
 * @create 2022/4/6 12:07
 * <p>
 * 位运算
 */
public class NumericRangeByBitAnd {
    public static void main(String[] args) {
        NumericRangeByBitAnd numericRangeByBitAnd = new NumericRangeByBitAnd();
        System.out.println(numericRangeByBitAnd.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
