package com.offer.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Basil
 * @create 2022/12/17 9:21
 * @description com.offer.mid Algorithm
 */
public class HuaWeiSecond {
    public static void main(String[] args) {
        System.out.println(test("abcabcbb"));
        System.out.println(test("bbbbbb"));
    }

    public static int test(String s){
        if (s.length() == 1){
            return 1;
        }

        int left = 0, right = 1, ans = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                ans++;
            }else {
                while (s.charAt(right) != s.charAt(left)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
