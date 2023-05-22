package com.offer.mid.DBFS;

import com.offer.mid.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Basil
 * @create 2022/3/27 20:08
 * @description 117. 填充每个节点的下一个右侧节点指针 II(深/广度优先遍历)
 */
public class FillNextNodeRight {
    public static void main(String[] args) {
        FillNextNodeRight fillNextNodeRight = new FillNextNodeRight();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        System.out.println(fillNextNodeRight.connect(root));
        Node error = new Node(1);
        error.left = new Node(2);
        System.out.println(fillNextNodeRight.connect(error));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                assert f != null;
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}
