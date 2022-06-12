package com.offer.easy.binarySearch;

/**
 * @author Basil
 * @create 2022/3/4 14:18
 * <p>
 * 二分查找
 */
public class FirstWrongVersion {
    public static void main(String[] args) {
        FirstWrongVersion fwv = new FirstWrongVersion();
        System.out.println(fwv.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        if (n <= 1) {
            return n;
        }
        int left = 1;
        int right = n;
        while (left < right) {
            int bad = left + (right - left) / 2;
            if (isBadVersion(bad)) {
                right = bad;
            } else {
                left = bad + 1;
            }
        }
        return right;
    }

    public boolean isBadVersion(int version) {
        return version >= 3;
    }
}