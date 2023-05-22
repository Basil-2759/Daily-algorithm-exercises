package com.offer.easy;

import java.util.Stack;

/**
 * @author Basil
 * @create 2022/11/16 19:42
 * @description 剑指 Offer 09. 用两个栈实现队列
 * @note 一个队列作为输入栈，一个作为输出栈，输出的时候把输入栈都倒进来就行了
 */
public class CQueue {
    private Stack<Integer> add;
    private Stack<Integer> del;

    public CQueue() {
        add = new Stack<>();
        del = new Stack<>();
    }

    public void appendTail(int value) {
        add.push(value);
    }

    public int deleteHead() {
        if (!del.isEmpty()) {
            return del.pop();
        } else {
            while (!add.isEmpty()) {
                del.push(add.pop());
            }
            return del.isEmpty() ? -1 : del.pop();
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        queue.appendTail(5);
        queue.appendTail(6);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
