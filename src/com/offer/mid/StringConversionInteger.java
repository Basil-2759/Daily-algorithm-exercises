package com.offer.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Basil
 * @create 2022/12/11 16:02
 * @description 面试题67. 把字符串转换成整数
 * @note 自动机。学到手都是活
 */
public class StringConversionInteger {
    public static void main(String[] args) {
        System.out.println(strToInt("42"));
    }

    public static int strToInt(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = new HashMap<>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int getCol(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}