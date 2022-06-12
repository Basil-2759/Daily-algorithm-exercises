package com.offer.mid;

import com.offer.easy.*;

import java.util.Arrays;

public class RebuildBTree {
    public static void main(String[] args) {
        RebuildBTree rebuildBTree=new RebuildBTree();
        int[] preorder={3,9,20,15,7};
        int[] inorder= {9,3,15,20,7};
        System.out.println(rebuildBTree.buildTree(preorder,inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));

        return root;
    }
}
