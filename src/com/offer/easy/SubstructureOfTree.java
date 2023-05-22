package com.offer.easy;

import com.offer.TreeNode;

/**
 * @author Basil
 * @create 2022/11/23 10:10
 * @description 剑指 Offer 26. 树的子结构
 */
public class SubstructureOfTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(4);
        a.right = new TreeNode(5);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(2);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(1);

        System.out.println(isSubStructure(a, b));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
