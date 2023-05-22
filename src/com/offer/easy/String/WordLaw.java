package com.offer.easy.String;

import java.util.HashMap;

/**
 * @author Basil
 * @create 2022/8/17 9:07
 * @title 290. 单词规律
 * @notes 利用哈希表存储对应的规律,需要注意的是，两个字符串是“双射”关系，需要两个哈希表存储。
 */
public class WordLaw {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        //数量关系可能不一致
        if (strings.length != pattern.length()){
            return false;
        }
        //解决双射
        HashMap<Character, String> chTwoStr = new HashMap<>();
        HashMap<String, Character> strTwoCh = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //若找到了重复的key，则看是否value对的上，否则不符合规律
            if (chTwoStr.containsKey(pattern.charAt(i)) && !chTwoStr.get(pattern.charAt(i)).equals(strings[i])){
                return false;
            }
            if (strTwoCh.containsKey(strings[i]) && !strTwoCh.get(strings[i]).equals(pattern.charAt(i))){
                return false;
            }
            chTwoStr.put(pattern.charAt(i), strings[i]);
            strTwoCh.put(strings[i], pattern.charAt(i));
        }

        return true;
    }
}
