package com.offer.easy;

import com.offer.ListNode;

public class TheBottomK {
    public static void main(String[] args) {
        TheBottomK theBottomK=new TheBottomK();
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        listNode1.next.next.next.next=new ListNode(5);

        System.out.println(theBottomK.getKthFromEnd(listNode1,2).val);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode listNode=head;
        int j=0;

        while (listNode!=null){
            j++;
            listNode=listNode.next;
        }
        j=j-k;
        listNode=head;
        for (int i = 0; i < j; i++) {
            listNode= listNode.next;
        }
        return listNode;
    }
}
