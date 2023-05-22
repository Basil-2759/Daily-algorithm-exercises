package com.offer;

/**
 * @author Basil
 * @create 2022/4/17 15:50
 */
public class MinShengFirst {
    public static void main(String[] args) {
        System.out.println(totalScore("100001000001", "ABD"));
        System.out.println(totalScore("", "ABC"));
    }

    public static int totalScore(String s, String t) {
        int score = 0;
        if (s.length() == 0 || t.length() == 0 || s == null || t == null) {
            return score;
        }
        char[] table = new char[]{'A', 'B', 'C', 'D'};
        for (int i = 1; i <= t.length(); i++) {
            int k = 0;
            int num = 0;
            boolean flag = false;
            for (int j = 4 * (i - 1); j < 4 * i; j++) {
                if (s.charAt(j) == '1') {
                    num++;
                    if (t.charAt(i - 1) == table[k]) {
                        flag = true;
                    }
                }
                k++;
            }
            if (num == 1 && flag == true){
                score++;
            }
        }
        return score;
    }
}
