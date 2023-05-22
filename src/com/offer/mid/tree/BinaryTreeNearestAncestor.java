package com.offer.mid.tree;

import com.offer.TreeNode;

/**
 * @author Basil
 * @create 2022/8/21 15:37
 * @title 236. 二叉树的最近公共祖先
 * @notes
 */
public class BinaryTreeNearestAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        TreeNode p = treeNode.left;
        TreeNode q = p.right.right;

        BinaryTreeNearestAncestor binaryTreeNearestAncestor = new BinaryTreeNearestAncestor();
        binaryTreeNearestAncestor.lowestCommonAncestor(treeNode, p, q);
    }

    private TreeNode ans;

    public BinaryTreeNearestAncestor() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);
        if ((lSon && rSon) || ((root.val == p.val || root.val == q.val) && (lSon || rSon))) {
            ans = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}
