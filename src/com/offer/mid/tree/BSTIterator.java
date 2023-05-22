package com.offer.mid.tree;

import com.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/8/21 11:14
 * @title 173. 二叉搜索树迭代器
 * @notes
 */
public class BSTIterator {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);

        BSTIterator bSTIterator = new BSTIterator(treeNode);
        bSTIterator.next();    // 返回 3
        bSTIterator.next();    // 返回 7
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 9
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 15
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 20
        bSTIterator.hasNext(); // 返回 False
    }

    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}
