package com.offer.easy;

public class DeleteListNode {
    public static void main(String[] args) {
        DeleteListNode deleteListNode=new DeleteListNode();

        ListNode listNode=new ListNode(-3);
        listNode.next=new ListNode(5);
        listNode.next.next=new ListNode(-99);
//        listNode.next.next.next=new ListNode(9);

        System.out.println(deleteListNode.deleteNode(listNode,-99).val);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){return null;};
        if (head.val==val){return head.next;}

        ListNode listNode=head;
        ListNode tool=null;

        while (listNode == null){
            if (listNode.val==val){
                tool.next=tool.next.next;
                break;
            }
            tool=listNode;
            listNode=listNode.next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}