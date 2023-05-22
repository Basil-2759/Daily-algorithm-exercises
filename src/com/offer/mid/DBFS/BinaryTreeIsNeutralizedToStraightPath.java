package com.offer.mid.DBFS;

import com.offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Basil
 * @create 2022/11/30 20:59
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class BinaryTreeIsNeutralizedToStraightPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, target, deque, ans);
        return ans;
    }

    public static void dfs(TreeNode node, int target, Deque<Integer> deque, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        deque.offerLast(node.val);
        target -= node.val;
        if (node.right == null && node.left == null && target == 0) {
            ans.add(new ArrayList<>(deque));
        }
        dfs(node.left, target, deque, ans);
        dfs(node.right, target, deque, ans);
        deque.pollLast();
    }
}
