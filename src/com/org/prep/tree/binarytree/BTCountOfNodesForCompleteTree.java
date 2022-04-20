package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTCountOfNodesForCompleteTree {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);

        System.out.println(countOfNodes(node));
    }
    private static int countOfNodes(TreeNode node){
        if(node==null) return 0;
        int leftLevel=0;
        TreeNode leftNode= node;
        TreeNode rightNode=node;
        while (leftNode!=null){
            leftNode=leftNode.left;
            leftLevel=leftLevel+1;
        }
        int rightLevel=0;

        while (rightNode!=null){
            rightNode=rightNode.right;
            rightLevel=rightLevel+1;
        }
        if(leftLevel==rightLevel){
            return (int) (Math.pow(2,leftLevel)-1);
        }else {
            return 1+countOfNodes(node.left)+countOfNodes(node.right);
        }


    }

}
