package com.offer.easy.linkedList;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/8/19 10:40
 * @title 160. 相交链表
 * @notes 除了用set以外，还可以用双指针的方法降低空间复杂度
 */
public class CrossLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(8);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(1);
        listNode2.next.next.next = new ListNode(8);
        listNode2.next.next.next.next = new ListNode(4);
        listNode2.next.next.next.next.next = new ListNode(5);

        getIntersectionNode(listNode1, listNode2);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //解法的关键在于证明。详见题解
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
