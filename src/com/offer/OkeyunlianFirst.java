package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/4/17 20:02
 */
public class OkeyunlianFirst {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int maxDepth (String s) {
        List<Integer> flag = new ArrayList<>();
        int f = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                flag.add(++f);
            }else if (s.charAt(i) == ')'){
                flag.add(--f);
            }
        }
        for (int i = 0; i < flag.size(); i++) {
            depth = Math.max(depth, flag.get(i));
        }
        return depth;
    }
}
