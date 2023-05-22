package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Basil
 * @create 2022/9/8 18:48
 */
public class HuaweiOD {
    public static void main(String[] args) {
        //出栈入栈：
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String[] numbers = sc.nextLine().split(" ");
        for (String number : numbers) {
            int add = Integer.parseInt(number);
            addAndCompare(stack, add);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void addAndCompare(Stack<Integer> stack, int add){
        if (stack.isEmpty()){
            stack.push(add);
            return;
        }
        int sum = stack.peek();
        List<Integer> list = new ArrayList<>();
        if (add < sum){
            stack.add(add);
        }else if (add == sum){
            stack.pop();
            addAndCompare(stack, 2 * add);
        }else {
            while (!stack.isEmpty() && add > sum){
                list.add(stack.pop());
                if (stack.isEmpty()){
                    for (int i = list.size() - 1; i >= 0; i--) {
                        stack.add(list.get(i));
                    }
                    stack.add(add);
                    break;
                }
                sum += stack.peek();
                if (add < sum){
                    for (int i = list.size() - 1; i >= 0; i--) {
                        stack.add(list.get(i));
                    }
                    stack.add(add);
                }else if (add == sum){
                    stack.pop();
                    addAndCompare(stack, 2 * add);
                }
            }
        }
    }

    public static void two(){
        //字母接龙
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        List<String> equalsWords = new ArrayList<>(sc.nextInt());
        while (sc.hasNextLine()) {
            equalsWords.add(sc.nextLine());
        }
        List<String> lengthWords = new ArrayList<>();
        List<String> dicWords = new ArrayList<>();
        StringBuilder ans = new StringBuilder("");

        char connect = equalsWords.get(point).charAt(equalsWords.get(point).length() - 1);
        equalsWords.remove(point);
        for (String word : equalsWords) {
            if (word.charAt(0) == connect) {
                lengthWords.add(word);
            }
        }

//        lengthWords.sort(c -> c.length());
        int length = lengthWords.get(0).length();
        int i = 0;
        while (lengthWords.get(i).length() == length) {
            dicWords.add(lengthWords.get(i));
        }
        boolean turn = false;
        for (int j = 1; j < dicWords.get(0).length(); j++) {
            char c = dicWords.get(0).charAt(j);
            String biggest = null;
            for (String word : dicWords) {
                if (word.charAt(c) > c) {
                    c = word.charAt(c);
                    biggest = word;
                    turn = true;
                }
            }
            if (turn) {
                ans.append(biggest);
                break;
            }
        }
    }

    public static void one() {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        //修正左右区域边界值
        int head = Math.min(Math.max(sc.nextInt(), 0), words.length - 1);
        int tail = Math.min(Math.max(sc.nextInt(), 0), words.length - 1);

        while (head < tail) {
            String s = words[head];
            words[head] = words[tail];
            words[tail] = s;
            head++;
            tail--;
        }
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
