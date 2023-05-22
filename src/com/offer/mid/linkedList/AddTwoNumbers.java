package com.offer.mid.linkedList;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/8/18 15:42
 * @title 2. 两数相加
 * @notes 模拟竖式加法，补位用0，最后进位如果为1，记得加上。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);

        addTwoNumbers(listNode1, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //记录答案
        ListNode answer = null, tail = null;
        //进位
        int add = 0;
        while (l1 != null || l2 != null){
            //补位为0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + add;
            if (answer == null){
                answer = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            add = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (add > 0){
            tail.next = new ListNode(add);
        }

        return answer;
    }
}
