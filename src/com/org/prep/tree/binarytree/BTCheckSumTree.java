package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTCheckSumTree {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(checkSumTree(node));

    }

    public static boolean checkSumTree(TreeNode node) {
        if (node == null || (node.left != null && node.right != null)) {
            return true;
        }
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = node.left.data;
        }
        if (node.right != null) {
            right = node.right.data;
        }
        if ((node.data == left + right) && checkSumTree(node.left) && checkSumTree(node.right)) {
            return true;
        } else {
            return false;
        }
    }
}
