package com.offer.easy;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/3/13 11:33
 */
public class TwoLinkedListsII {
    public static void main(String[] args) {
        TwoLinkedListsII twoLinkedListsII = new TwoLinkedListsII();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = twoLinkedListsII.mergeTwoLists(listNode1, listNode2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
