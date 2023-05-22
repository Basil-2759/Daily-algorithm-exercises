package com.offer.mid.tree;

import com.offer.TreeNode;

import java.util.Arrays;

/**
 * @author Basil
 * @description 剑指 Offer 07. 重建二叉树
 * @note 利用前序遍历和中序遍历的特点去求
 */
public class RebuildBTree {
    public static void main(String[] args) {
        RebuildBTree rebuildBTree =new RebuildBTree();
        int[] preorder={3,9,20,15,7};
        int[] inorder= {9,3,15,20,7};
        System.out.println(rebuildBTree.buildTree(preorder,inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pLength = preorder.length;
        if (pLength == 0) {
            return null;
        }
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < pLength; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, pLength), Arrays.copyOfRange(inorder, rootIndex + 1, pLength));

        return root;
    }
}
