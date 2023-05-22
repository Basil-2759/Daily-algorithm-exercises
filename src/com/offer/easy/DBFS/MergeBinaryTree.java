package com.offer.easy.DBFS;

import com.offer.TreeNode;

/**
 * @author Basil
 * @create 2022/3/12 11:59
 * <p>
 * 深/广度优先
 */
public class MergeBinaryTree {
    public static void main(String[] args) {
        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);

        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode root3 = new TreeNode(1);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);

        TreeNode root6 = new TreeNode(1);

        System.out.println(mergeBinaryTree.mergeTrees(root1, root2));
        System.out.println(mergeBinaryTree.mergeTrees(root3, root4));
        System.out.println(mergeBinaryTree.mergeTrees(null, root6).val);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode aws = new TreeNode();
        if (root1 == null || root2 == null) {
            aws = root1 == null ? root2 : root1;
        }else {
            aws = merge(root1, root2, aws);
        }
        //为什么我不能直接return merge(root1,root2,aws)？
        return aws;
    }

    public TreeNode merge(TreeNode root1, TreeNode root2, TreeNode aws) {
        aws.val = root1.val + root2.val;
        if (root1.left == null || root2.left == null) {
            aws.left = root1.left == null ? root2.left : root1.left;
        } else {
            aws.left = new TreeNode();
            merge(root1.left, root2.left, aws.left);
        }
        if (root1.right == null || root2.right == null) {
            aws.right = root1.right == null ? root2.right : root1.right;
        } else {
            aws.right = new TreeNode();
            merge(root1.right, root2.right, aws.right);
        }
        return aws;
    }
}
