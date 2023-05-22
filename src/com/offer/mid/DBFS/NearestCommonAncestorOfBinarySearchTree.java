package com.offer.mid.DBFS;

import com.offer.TreeNode;

/**
 * @author Basil
 * @create 2022/12/4 20:25
 * @description 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @note 利用二叉搜索树的性质
 */
public class NearestCommonAncestorOfBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left;
        TreeNode q = p.right.right;

        System.out.println(lowestCommonAncestor(root, p ,q));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
