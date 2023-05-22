package com.huawei.easy;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/9/3 9:45
 * @title HJ1 字符串最后一个单词的长度
 */
public class StringTheLastLength {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printLength(s);
    }

    public static void printLength(String s){
        String[] strings = s.split(" ");
        System.out.println(strings[strings.length - 1].length());
    }
}
