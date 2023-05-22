package com.offer.mid;

import com.offer.ListNode;

/**
 * @author Basil
 * @create 2022/3/9 11:25
 */
public class DeleteLinkBottom {
    public static void main(String[] args) {
        DeleteLinkBottom deleteLinkBottom = new DeleteLinkBottom();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        deleteLinkBottom.removeNthFromEnd(head,3);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
