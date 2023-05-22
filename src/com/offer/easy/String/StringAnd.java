package com.offer.easy.String;

/**
 * @author Basil
 * @create 2022/8/16 15:52
 * @title 415. 字符串相加
 * @notes 竖式加法
 */
public class StringAnd {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "23"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
