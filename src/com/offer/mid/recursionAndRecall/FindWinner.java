package com.offer.mid.recursionAndRecall;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * @author Basil
 * @create 2022/11/5 19:17
 * @description com.offer.mid.recursionAndRecall Algorithm
 */
public class FindWinner {
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
        return Optional.ofNullable(queue.peek()).orElse(0);
    }
}
