package com.offer.easy.recursionAndRecall;

import com.offer.ListNode;

/**
 * @author Basil
 * @description 剑指 Offer 24. 反转链表
 * @note 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
 * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
 * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseLinkedList.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}