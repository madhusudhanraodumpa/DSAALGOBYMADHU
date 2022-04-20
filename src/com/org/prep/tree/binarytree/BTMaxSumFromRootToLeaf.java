package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTMaxSumFromRootToLeaf {
    public static void main(String args[]){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(maxValue(node,0,Integer.MIN_VALUE));
    }

    public static int maxValue(TreeNode node,int val,int maxValue){

        if(node.left==null && node.right==null){
            return val+node.data;
        }
        return Integer.max(maxValue(node.left,node.data+val,maxValue),
        maxValue(node.right,node.data+val,maxValue));

    }
}
