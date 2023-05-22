package com.offer.easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Basil
 * @deprecated 剑指 Offer 06. 从尾到头打印链表
 */
public class TraverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int a = 0;
        while (node != null) {
            a++;
            node = node.next;
        }
        int[] list = new int[a];
        for (int i = a - 1; i >= 0; i--) {
            list[i] = head.val;
            head = head.next;
        }
        return list;
    }

    public static int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
