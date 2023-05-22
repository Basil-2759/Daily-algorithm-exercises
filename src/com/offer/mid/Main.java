package com.offer.mid;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public char full(String que){
        char[] ch=que.toCharArray();
        Map charInt=new HashMap<Character,Integer>();
        for (char c : ch) {
            if(!charInt.containsKey(c)){
                int  count=0;
                for (char cc : ch) {
                    if(cc==c){
                        count++;
                        charInt.put(c, count);
                    }
                }
            }
        }

        Collection<Integer> values=charInt.values();
        Integer max=0;
        for (Integer value : values) {
            if(value>=max){
                max=value;
            }
        }

        return ch[max];
    }
}
