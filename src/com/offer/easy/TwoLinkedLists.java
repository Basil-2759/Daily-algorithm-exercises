package com.offer.easy;

import com.offer.ListNode;

/**
 * @author Basil
 */
public class TwoLinkedLists {
    public static void main(String[] args) {
        TwoLinkedLists twoLinkedLists=new TwoLinkedLists();
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(4);
        ListNode listNode2=new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);

        ListNode listNode = twoLinkedLists.mergeTwoLists(listNode1, listNode2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=l1.val < l2.val ? l1 :l2;
        ListNode listNode=head;

        while (!(l1==null&&l2==null)){
            if (l1==null||l2==null){
                listNode=l1==null ? l2 : l1;
                break;
            }else if (l1.val< l2.val){
                listNode=l1;
                l1=l1.next;
            }else {
                listNode=l2;
                l2=l2.next;
            }
            listNode=listNode.next;
        }

        return head;
    }
}