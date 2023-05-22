package com.offer.easy.doublePointer;

import com.offer.ListNode;

/**
 * @author Basil
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 */
public class TheBottomK {
    public static void main(String[] args) {
        TheBottomK theBottomK = new TheBottomK();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);

        System.out.println(theBottomK.getKthFromEnd(listNode1, 2).val);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
