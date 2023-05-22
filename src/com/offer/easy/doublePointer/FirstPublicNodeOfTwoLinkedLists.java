package com.offer.easy.doublePointer;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/11/27 20:32
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 * @note 可以用set，但时间复杂度过高
 */
public class FirstPublicNodeOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        getIntersectionNode(headA, headB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
