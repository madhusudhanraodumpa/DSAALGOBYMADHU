package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTMaxDepth {
    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(maxDepthIterative(node));
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static int maxDepthIterative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        int count = 0;

        while (true) {

            if (queue.isEmpty()) return height;
            count = queue.size();
            height++;
            while (count > 0) {
                TreeNode treeNode = queue.peek();
                queue.remove();
                count--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }


            }


        }
    }
}
