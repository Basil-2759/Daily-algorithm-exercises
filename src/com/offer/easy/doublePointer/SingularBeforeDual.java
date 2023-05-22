package com.offer.easy.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Basil
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class SingularBeforeDual {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(exchange2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }

    public static int[] exchange(int[] nums) {
        ArrayList<Integer> singular = new ArrayList<>();
        ArrayList<Integer> dual = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 1) {
                singular.add(num);
            } else {
                dual.add(num);
            }
        }

        for (int i = 0; i < singular.size(); i++) {
            nums[i] = singular.get(i);
        }
        for (int i = singular.size(); i < singular.size() + dual.size(); i++) {
            nums[i] = dual.get(i - singular.size());
        }
        return nums;
    }

    /**
     * @param nums；数组
     * @return 前面全是奇数后面全是偶数
     * @note 逐一交换第一个出现的偶数和最后一个奇数，往次循环
     */
    public static int[] exchange2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}