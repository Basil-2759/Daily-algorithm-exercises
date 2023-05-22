package com.offer.mid.tree;

import com.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/8/21 14:42
 * @title 199. 二叉树的右视图
 * @notes
 */
public class BinaryTreeRightView {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);

        System.out.println(rightSideView(treeNode));
    }

    /**
     * 深度优先
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private static void dfs(List<Integer> res, TreeNode node, int level) {
        if(node != null) {
            if(res.size() == level) {
                res.add(node.val);
            }
            dfs(res, node.right, level + 1);
            dfs(res, node.left, level + 1);
        }
    }
}
