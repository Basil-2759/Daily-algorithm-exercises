package com.offer.mid;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Basil
 * @create 2022/12/12 14:49
 * @description 面试题59 - II. 队列的最大值
 */
public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.max_value();
    }

    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
