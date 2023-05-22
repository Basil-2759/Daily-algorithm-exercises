package com.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/4/16 16:39
 */
public class Second360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numPoints = s.charAt(0);
        int numRoads = s.charAt(1);
        Scanner sc2 = new Scanner(System.in);
        String front = sc2.nextLine();
        Scanner sc3 = new Scanner(System.in);
        String rear = sc3.nextLine();
        Scanner sc4 = new Scanner(System.in);
        String roadLength = sc4.nextLine();
        Deque<Integer> deque = new ArrayDeque<>();
        int min = roadLength.charAt(0), flag = 0, sum = 0;

        for (int i = 1; i < roadLength.length(); i++) {
           if(roadLength.charAt(i) < min){
               min = roadLength.charAt(i);
               flag = i;
           }
        }
        sum += min;
        deque.addFirst((int) front.charAt(flag));
        deque.addFirst((int) rear.charAt(flag));

    }
}
