package com.offer.mid.linkedList;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/8/19 16:04
 * @title 24. 两两交换链表中的节点
 * @notes 双指针，设置好两个交换的节点和前节点，同时处理好临界条件即可。
 */
public class TwoTwoSwapLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode listNode = new ListNode(0, head);
        ListNode pre = listNode;
        ListNode l1 = listNode.next;
        ListNode l2 = l1.next;
        while (l1.next != null){
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
            if(l1.next != null){
                l1 = l1.next;
            }
            if(l1.next != null){
                l2 = l1.next;
            }
        }

        return listNode.next;
    }

    /**
     * 递归版本
     */
    public ListNode swapPairsII(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsII(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
