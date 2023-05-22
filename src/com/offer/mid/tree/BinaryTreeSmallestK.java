package com.offer.mid.tree;

import com.offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Basil
 * @create 2022/8/21 15:14
 * @title 230. 二叉搜索树中第K小的元素
 * @notes 利用中序遍历和二叉搜索树的原理
 */
public class BinaryTreeSmallestK {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);

        System.out.println(kthSmallest(treeNode, 1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
