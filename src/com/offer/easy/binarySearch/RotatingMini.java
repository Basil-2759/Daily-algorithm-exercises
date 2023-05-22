package com.offer.easy.binarySearch;

/**
 * @author Basil
 * @description 剑指 Offer 11. 旋转数组的最小数字
 * @note 二分查找（有疑惑）
 */
public class RotatingMini {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{1, 3, 5}));
    }

    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 为什么对比的标准换成 numbers[left] 就不行呢
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 去重
                right--;
            }
        }

        return numbers[left];
    }
}
