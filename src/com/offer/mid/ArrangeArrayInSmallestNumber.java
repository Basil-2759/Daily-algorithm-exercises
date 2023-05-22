package com.offer.mid;

/**
 * @author Basil
 * @create 2022/12/3 10:37
 * @description 面试题45. 把数组排成最小的数
 * @note 排序
 */
public class ArrangeArrayInSmallestNumber {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public static String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strings) {
            res.append(s);
        }
        return res.toString();
    }

    public static void quickSort(String[] strings, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strings[i];
        while (i < j) {
            while ((strings[j] + strings[l]).compareTo(strings[l] + strings[j]) >= 0 && i < j) {
                j--;
            }
            while ((strings[i] + strings[l]).compareTo(strings[l] + strings[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
        }
        strings[i] = strings[l];
        strings[l] = tmp;
        quickSort(strings, l, i - 1);
        quickSort(strings, i + 1, r);
    }
}
