package com.offer.hard.recursionAndRecall;

import com.offer.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/12/15 15:37
 * @description 剑指 Offer 37. 序列化二叉树
 */
public class SerializeTheBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        return reSerialize(root, "");
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));

        return reDeserialize(dataList);
    }

    public String reSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = reSerialize(root.left, str);
            str = reSerialize(root.right, str);
        }

        return str;
    }

    public TreeNode reDeserialize(List<String> dataList) {
        if ("None".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = reDeserialize(dataList);
        root.right = reDeserialize(dataList);

        return root;
    }
}
