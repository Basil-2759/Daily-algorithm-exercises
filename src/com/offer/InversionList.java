package com.offer;

public class InversionList {
    public static void main(String[] args) {
        InversionList inversionList = new InversionList();
        Node head = new Node("1"); //链表为  1->2->3->4
        head.next = new Node("2");
        head.next.next = new Node("3");
        head.next.next.next = new Node("4");
        head = inversionList.inversion(head,head,head.next);
        while (head!=null){
            System.out.print(head.value+"->");
            head=head.next;
        }
        System.out.print("null");
    }

    public Node inversion(Node head, Node prior,Node node){
        prior.next = node.next;
        if (head.equals(prior)) node.next = prior;
        else node.next = head;
        head = node;
        if (prior.next!=null)
        return inversion(head,prior,prior.next);
        else return head;
    }
}

//链表节点
class Node{
    Node next;
    String value;

    public Node(String value) {
        this.value = value;
    }
}