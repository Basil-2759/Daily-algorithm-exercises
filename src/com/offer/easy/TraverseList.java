package com.offer.easy;

public class TraverseList {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(2);
        System.out.println(reversePrint(listNode));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode node=head;
        int a=0;
        while (node!=null){
            a++;
            node=node.next;
        }
        int[] list = new int[a];
        for (int i=a-1;i>=0;i--){
            list[i]=head.val;
            head=head.next;
        }
        return list;
    }
}
