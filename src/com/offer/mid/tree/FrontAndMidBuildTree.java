package com.offer.mid.tree;

import com.offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Basil
 * @create 2022/10/30 22:23
 * @description com.offer.mid.tree Algorithm
 * @title 从前序与中序遍历序列构造二叉树
 */
public class FrontAndMidBuildTree {
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }

    public  static TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
        return root;
    }
}
