package com.offer.mid.recursionAndRecall;

/**
 * @author Basil
 * @create 2022/12/5 18:41
 * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @note 递归：
 */
public class AfterOrderTraversalSequenceTree {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    static boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
