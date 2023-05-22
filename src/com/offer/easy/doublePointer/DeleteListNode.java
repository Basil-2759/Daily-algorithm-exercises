package com.offer.easy.doublePointer;

import com.offer.ListNode;

/**
 * @author Basil
 * @description 剑指 Offer 18. 删除链表的节点
 */
public class DeleteListNode {
    public static void main(String[] args) {
        DeleteListNode deleteListNode = new DeleteListNode();
        ListNode listNode = new ListNode(-3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(-99);
        listNode.next.next.next = new ListNode(9);

        deleteListNode.deleteNode(listNode, -99);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}