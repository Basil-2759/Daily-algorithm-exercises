package com.offer.easy.recursionAndRecall;

import com.offer.TreeNode;

/**
 * @author Basil
 * @description 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorBTree {
    public static void main(String[] args) {
        MirrorBTree mirrorBTree = new MirrorBTree();
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(9);

        System.out.println(mirrorBTree.mirrorTree(head).left.val);
    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode tool;

        if (root == null) {
            return null;
        }
        tool = root.left;
        root.left = root.right;
        root.right = tool;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

