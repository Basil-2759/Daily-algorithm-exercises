package com.offer.mid.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Basil
 * @create 2022/8/20 15:03
 * @title 1823. 找出游戏的获胜者
 * @notes
 */
public class FindGameWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
