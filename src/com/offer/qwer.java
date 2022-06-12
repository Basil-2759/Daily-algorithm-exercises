package com.offer;

import java.util.Locale;

public class qwer {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(slove(nums.length,nums));
//        int[] values = new int[]{3, 7, 1, 3, 9};
//        int rodLength = values.length;
//
//        System.out.println("Max rod value: " + getValue(values, rodLength));
    }

    static int getValue(int[] values, int length) {
        if (length <= 0)
            return 0;
        int tmpMax = -1;
        for (int i = 0; i < length; i++) {
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
        return tmpMax;
    }

    public static int slove(int idx,int[] nums) {
        int max = Math.max(slove(idx - 2, nums), slove(idx - 1, nums));

        return max;
    }
    public void zhengZe(){
        String url="^(http://localhost:33022/mom/pe/).*";
        System.out.println("dhttp://localhost:33022/mom/pe/esop".matches(url));
    }

    public void stringMethod(){
        String s="hello";
        String t="HELLO".toLowerCase();
        String r=" \n\t\u3000Hello\r";
        String last="I Love You %d";

        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println(s.contains("ell"));
        System.out.println(s.indexOf("o"));
        System.out.println(r.trim());
        System.out.println(r.strip());
        System.out.println(last.replace("Love","Hate"));
        System.out.println(last.formatted(3000));

        s=s.toUpperCase();
        System.out.println(s);
    }
}
