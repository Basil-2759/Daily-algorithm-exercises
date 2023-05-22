package com.offer.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Basil
 * @create 2022/11/19 15:52
 * @description 剑指 Offer 35. 复杂链表的复制
 */
public class ReplicationOfComplexLinkedList {
    static Map<ComplexNode, ComplexNode> cachedNode = new HashMap<>();

    public static void main(String[] args) {
        ComplexNode head = new ComplexNode(7);
        ComplexNode head13 = new ComplexNode(13);
        ComplexNode head11 = new ComplexNode(11);
        ComplexNode head10 = new ComplexNode(10);
        ComplexNode head1 = new ComplexNode(1);
        head.next = head13;
        head13.next = head11;
        head11.next = head10;
        head10.next = head1;
        head13.random = head;
        head11.random = head1;
        head10.random = head11;
        head1.random = head;

        System.out.println(copyRandomList(head));
    }

    public static ComplexNode copyRandomList(ComplexNode head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            ComplexNode headNew = new ComplexNode(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}

class ComplexNode {
    int val;
    ComplexNode next;
    ComplexNode random;

    public ComplexNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}