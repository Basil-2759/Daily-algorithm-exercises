package com.offer.mid.linkedList;

import com.offer.ListNode;

import java.util.HashSet;

/**
 * @author Basil
 * @create 2022/8/18 16:26
 * @title 142. 环形链表 II
 * @notes
 */
public class CircularLinkedListII {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(-4);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;

        detectCycle(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode tail = head;
        HashSet<ListNode> appearCir = new HashSet<>();
        while (tail != null){
            if (appearCir.contains(tail)){
                return tail;
            }else {
                appearCir.add(tail);
            }
            tail = tail.next;
        }

        return null;
    }
}
