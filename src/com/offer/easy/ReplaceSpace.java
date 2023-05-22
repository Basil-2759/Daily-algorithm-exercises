package com.offer.easy;

/**
 * @author Basil
 * @description 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are family"));
    }


    public static String replaceSpace(String str) {
        if (str == null) {
            return null;
        }
        //选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < str.length(); i++) {
            //str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            if (" ".equals(String.valueOf(str.charAt(i)))){
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
