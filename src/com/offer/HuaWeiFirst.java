package com.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/12/12 18:37
 * @description com.offer Algorithm
 */
public class HuaWeiFirst {
    public static void main(String[] args) {
//        System.out.println(test("23"));
//        System.out.println(test(""));
//        System.out.println(test("2"));
//        System.out.println(test("32"));

        nine();
    }

    static HashMap<Character, String> phone = new HashMap<>(8);
    public static List<String> test(String digits){
        Deque deque = new LinkedList();
        List<String> ans = new ArrayList<>();


        dfs(digits, deque, ans, 0);

        return ans;
    }

    public static void dfs(String digits, Deque deque, List<String> ans, int index){
        if (index == digits.length()){
            ans.add(deque.toString());
            return;
        }
        String string = phone.get(digits.charAt(index));
        for (int i = 0; i < string.length(); i++){
            deque.offerLast(string.charAt(i));
            dfs(digits, deque, ans, index + 1);
            deque.pollLast();
        }
    }

    public static void nine(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + " ");
            }
            System.out.println();
        }
    }
}
