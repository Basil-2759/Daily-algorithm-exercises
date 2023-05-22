package com.offer.easy;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/3/9 10:47
 */
public class MiddleNodeLink {
    public static void main(String[] args) {
        MiddleNodeLink middleNodeLink = new MiddleNodeLink();
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNodeLink.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode right = head;
        int i = 1;
        while (right.next != null){
            right = right.next;
            i++;
        }
        for (int j = 0; j < i/2; j++) {
            head = head.next;
        }

        return head;
    }
}