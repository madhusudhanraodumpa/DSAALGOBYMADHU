package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTConvertTreeToSumTree {
    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(sumTree(node));
    }

    public static int sumTree(TreeNode node) {


        if (node == null) return 0;
        int leftValue = sumTree(node.left);
        int rightValue = sumTree(node.right);
        int nodeVal = node.data;
        node.data = leftValue + rightValue;
        return leftValue + rightValue + nodeVal;
    }
}
