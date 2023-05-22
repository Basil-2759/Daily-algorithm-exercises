package com.offer.mid.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Basil
 * @create 2022/4/2 19:34
 * @description 139. 单词拆分 (动态规划)
 */
public class WordSplit {
    public static void main(String[] args) {
        WordSplit wordSplit = new WordSplit();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordSplit.wordBreak("leetcode", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
