package com.offer.easy;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Basil
 * @description 剑指 Offer 09. 用两个栈实现队列
 * @note 解题关键在于 deleteHead()。
 *      其次，使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢；
 *      原因的话是Stack继承了Vector接口，而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。
 *      可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，
 *      所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。
 *      但是我的意思不是像100%代码那样直接使用一个LinkedList当做队列，那确实是快，但是不符题意
 */
public class StackImplementationQueue {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {
        /*
         优化方法如下：
         LinkedList<Integer> upStack;
         LinkedList<Integer> downStack;
        */
        Stack<Integer> upStack;
        Stack<Integer> downStack;

        public CQueue() {
            upStack = new Stack<>();
            downStack = new Stack<>();
        }

        public void appendTail(int value) {
            upStack.push(value);
        }

        public int deleteHead() throws EmptyStackException {
            if (downStack.isEmpty()) {
                if (!upStack.isEmpty()) {
                    while (!upStack.isEmpty()) {
                        downStack.push(upStack.pop());
                    }
                    return downStack.pop();
                } else {
                    return -1;
                }
            } else {
                return downStack.pop();
            }
        }
    }
}
