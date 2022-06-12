package com.offer.easy;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackImplementationQueue {
    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
    static class CQueue {
        Stack<Integer> upStack;
        Stack<Integer> downStack;

        public CQueue() {
            upStack=new Stack<Integer>();
            downStack=new Stack<Integer>();
        }

        public void appendTail(int value) {
            upStack.push(value);
        }

        public int deleteHead() throws EmptyStackException{
            if (downStack.isEmpty()){
                if (!upStack.isEmpty()){
                    while (!upStack.isEmpty()){
                        downStack.push(upStack.pop());
                    }
                    return downStack.pop();
                }else {
                    return -1;
                }
            }else {
                return downStack.pop();
            }
        }
    }
}
