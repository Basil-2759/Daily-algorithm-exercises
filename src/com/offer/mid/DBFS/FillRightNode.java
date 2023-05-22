package com.offer.mid.DBFS;

import com.offer.mid.Node;

/**
 * @author Basil
 * @create 2022/3/12 21:13
 * <p>
 * 深/广度优先
 */
public class FillRightNode {
    public static void main(String[] args) {
        FillRightNode fillRightNode = new FillRightNode();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(fillRightNode.connect(root));
    }

    public Node connect(Node root) {
        if (root != null) {
            root.next = null;
            root = con(root);
        }
        return root;
    }

    public Node con(Node parent) {
        if (parent.left != null) {
            parent.left.next = parent.right;
            //关键要利用父节点的next指针
            parent.right.next = parent.next != null ? parent.next.left : null;
            con(parent.left);
            con(parent.right);
        }
        return parent;
    }
}
