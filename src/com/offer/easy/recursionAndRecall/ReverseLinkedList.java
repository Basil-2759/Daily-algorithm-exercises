package com.offer.easy.recursionAndRecall;

import com.offer.mid.ListNode;

/**
 * @author Basil
 *
 * 递归
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList=new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseLinkedList.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}