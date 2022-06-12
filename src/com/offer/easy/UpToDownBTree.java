package com.offer.easy;

import java.util.ArrayList;
import java.util.List;

public class UpToDownBTree {
    public static void main(String[] args) {
        UpToDownBTree upToDownBTree=new UpToDownBTree();
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.right=new TreeNode(20);
        treeNode.right.left=new TreeNode(15);
        treeNode.right.right=new TreeNode(7);

        System.out.println(upToDownBTree.levelOrder(treeNode));;
    }

    List<List<Integer>> list=new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root,0);
        return list;
    }

    public void traverse(TreeNode node,int f){
        if (node!=null){
            if (list.size()<=f)list.add(new ArrayList<>());
            list.get(f).add(node.val);
            traverse(node.left,f+1);
            traverse(node.right,f+1);
        }
    }
}
