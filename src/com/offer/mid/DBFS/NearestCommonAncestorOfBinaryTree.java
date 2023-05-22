package com.offer.mid.DBFS;

import com.offer.TreeNode;

/**
 * @author Basil
 * @create 2022/12/4 19:41
 * @description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @note l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
 *       l、r 任一为空，说明 LCA 位于另一子树或其祖先中（可我还是不懂……）
 */
public class NearestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p = root.left;
        TreeNode q = p.right.right;

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
    }
}
