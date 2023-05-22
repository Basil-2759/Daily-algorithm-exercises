package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/11/25 19:00
 * @description 剑指 Offer 46. 把数字翻译成字符串
 */
public class TranslateNumbersIntoStrings {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(506));
    }

    public static int translateNum(int num) {
        int length = String.valueOf(num).length();
        // 一个记录答案，一个记录num里的数字
        int[] ans = new int[length], list = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            list[i] = num % 10;
            num /= 10;
        }
        ans[0] = 1;
        // 这里要提前计算好，便于下面循环的执行，要注意十位上的数为0的情况
        if (length > 1){
            ans[1] = list[1] + list[0] * 10 < 26 && list[0] != 0 ? 2 : 1;
        }
        for (int i = 2; i < length; i++) {
            // 动态规划，每次遍历到新的数时，要考虑单独变成字母和结合上个数字组合成两位数变成字母的情况
            // 单独的话不用考虑，结合成二位数则要考虑是否超过阈值，同时考虑十位为0的情况
            if (list[i - 1] * 10 + list[i] < 26 && list[i - 1] != 0) {
                // 动态转移方程
                ans[i] = ans[i - 2] + ans[i - 1];
            } else {
                ans[i] = ans[i - 1];
            }

        }

        return ans[length - 1];
    }
}
