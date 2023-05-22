package com.offer.easy;

import com.offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Basil
 * @description 剑指 Offer - 从上到下打印二叉树（I、II、III）
 */
public class UpToDownBTree {
    public static void main(String[] args) {
        UpToDownBTree upToDownBTree = new UpToDownBTree();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(upToDownBTree.levelOrderII(treeNode));
        System.out.println(Arrays.toString(upToDownBTree.levelOrder(treeNode)));
        System.out.println(upToDownBTree.levelOrderIII(treeNode));
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderII(TreeNode root) {
        traverseII(root, 0);
        return list;
    }

    public void traverseII(TreeNode node, int f) {
        if (node != null) {
            if (list.size() <= f) {
                list.add(new ArrayList<>());
            }
            list.get(f).add(node.val);
            traverseII(node.left, f + 1);
            traverseII(node.right, f + 1);
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<List<Integer>> levelOrderIII(TreeNode root) {
        traverseII(root, 0);
        for(int i=1;i<list.size();i+=2){
            Collections.reverse(list.get(i));
        }
        return list;
    }
}
