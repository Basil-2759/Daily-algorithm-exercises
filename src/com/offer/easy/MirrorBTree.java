package com.offer.easy;

import com.offer.TreeNode;

public class MirrorBTree {
    public static void main(String[] args) {
        MirrorBTree mirrorBTree=new MirrorBTree();
        TreeNode head=new TreeNode(4);
        head.left=new TreeNode(2);
        head.right=new TreeNode(7);
        head.left.left=new TreeNode(1);
        head.left.right=new TreeNode(3);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(9);

        System.out.println(mirrorBTree.mirrorTree(head).left.val);
    }

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode tool=null;

        if (root==null){
            return root;
        }
        tool=root.left;
        root.left=root.right;
        root.right=tool;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

