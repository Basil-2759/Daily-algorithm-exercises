package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/29 20:08
 * @title 括号生成
 * 递归/回溯
 */
public class GenerationOfBrackets {
    public static void main(String[] args) {
        GenerationOfBrackets generationOfBrackets = new GenerationOfBrackets();
        System.out.println(generationOfBrackets.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
