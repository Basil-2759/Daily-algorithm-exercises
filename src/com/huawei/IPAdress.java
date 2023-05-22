package com.huawei;

import java.util.Arrays;

/**
 * @author Basil
 * @version 15
 * @create 2022/9/15 11:55
 * @description com.huawei Algorithm
 */
public class IPAdress {
    public static void main(String[] args) {
        String s = "10.0.3.193";
        System.out.println(adress(s));
    }

    public static int adress(String s){
        String[] nums= s.split("\\.");
        StringBuilder[] twoNums = new StringBuilder[4];
        for (int i = 0; i < twoNums.length; i++) {
            twoNums[i] = new StringBuilder("");
        }
        int answer = 0;
        int i = 0;
        for (String num : nums) {
            int tenNum = Integer.parseInt(num);
            if (tenNum == 0){
                twoNums[i].append("00000000");
            }
            while (tenNum >= 1){
                twoNums[i].append(tenNum % 2);
                tenNum /= 2;
            }
            i++;
        }
        for (StringBuilder twoNum : twoNums) {
            while (twoNum.length() <= 8){
                twoNum.append("0");
            }
            twoNum.reverse();
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder twoNum : twoNums) {
            ans.append(twoNum);
        }
        for (int j = 0; j < ans.length(); j++) {
            char c = ans.charAt(i);
            if (ans.charAt(i) == 49){
                answer += Math.pow(2, ans.length() - 1 - j);
            }
        }

        return answer;
    }

}
