package com.offer.easy.DBFS;

import com.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/11/30 18:41
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 * @note 中序遍历，则会形成递增序列，从而获得第k个最大值
 */
public class KThLargestNodeOfBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthLargest(root, 2));
    }

    public static int kthLargest(TreeNode root, int k) {
        // clarification:  root == null?   k <= 1?
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(list.size() - k);
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            helper(root.right, list);
        }
    }
}
