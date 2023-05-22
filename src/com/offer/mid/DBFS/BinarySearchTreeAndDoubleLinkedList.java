package com.offer.mid.DBFS;

import com.offer.mid.Node;

/**
 * @author Basil
 * @create 2022/11/30 20:17
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class BinarySearchTreeAndDoubleLinkedList {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        System.out.println(treeToDoublyList(root).val);
    }

    static Node pre, head;

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    static void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
