package com.offer.mid.recursionAndRecall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/3/15 10:24
 * <p>
 * 递归/回溯
 */
public class LetterCaseArrangement {
    public static void main(String[] args) {
        LetterCaseArrangement letterCaseArrangement = new LetterCaseArrangement();
        System.out.println(letterCaseArrangement.letterCasePermutation("a1b2c"));
    }

    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        dfs(s, ans, 0);

        List<String> finals = new ArrayList();
        for (StringBuilder sb : ans) {
            finals.add(sb.toString());
        }
        return finals;
    }

    public void dfs(String s, List<StringBuilder> ans, int begin) {
        if (s.length() == begin) {
            return;
        }
        if (Character.isLetter(s.charAt(begin))) {
            String low = String.valueOf(s.charAt(begin)).toLowerCase();
            String up = String.valueOf(s.charAt(begin)).toUpperCase();
            int size = ans.size();
            for (int i = 0; i < size; ++i) {
                ans.add(new StringBuilder(ans.get(i)));
                ans.get(i).append(low);
                ans.get(size + i).append(up);
            }
        } else {
            for (StringBuilder as : ans) {
                as.append(s.charAt(begin));
            }
        }
        dfs(s, ans, begin + 1);
    }

    public List<String> letterCasePermutation2(String s) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (StringBuilder an : ans) {
                    an.append(c);
                }
            }
        }

        List<String> finals = new ArrayList();
        for (StringBuilder sb : ans) {
            finals.add(sb.toString());
        }
        return finals;
    }
}
