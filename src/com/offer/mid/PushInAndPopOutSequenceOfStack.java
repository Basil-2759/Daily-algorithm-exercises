package com.offer.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Basil
 * @create 2022/12/11 11:29
 * @description 剑指 Offer 31. 栈的压入、弹出序列
 */
public class PushInAndPopOutSequenceOfStack {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
