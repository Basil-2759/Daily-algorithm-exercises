package com.offer.mid.doublePointer;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/3/21 14:47
 * @title 82. 删除排序链表中的重复元素 II
 * @notes 双指针
 */
public class DeleteLinkRepeatII {
    public static void main(String[] args) {
        DeleteLinkRepeatII deleteLinkRepeat = new DeleteLinkRepeatII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteLinkRepeat.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
