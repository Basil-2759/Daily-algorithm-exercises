package com.offer.easy;

import java.util.Scanner;

/**
 * 旋转数组的最小数字
 */
public class RotatingMini {
    public static void main(String[] args) {
        RotatingMini rotatingMini=new RotatingMini();
        Scanner scanner=new Scanner(System.in);

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i]=scanner.nextInt();
        }

        System.out.println(rotatingMini.minArray(numbers));
    }

    public int minArray(int[] numbers) {
//        int flag;
        int[] aws = new int[0];

        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i+1]<numbers[i]){
//                flag=i+1;
                return numbers[i+1];
            }
        }
//        for (int i = 0; i < numbers.length - flag; i++) {
//            aws[i]=numbers[flag];
//        }
//        for (int i = 0; i < flag; i++) {
//            aws[numbers.length-flag]=numbers
//        }
        return numbers[0];
    }
}
