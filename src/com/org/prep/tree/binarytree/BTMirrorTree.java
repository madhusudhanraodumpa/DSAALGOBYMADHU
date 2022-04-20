package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BTMirrorTree {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
    }

    public static void mirrorTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() > 0) {
            TreeNode currentNode = queue.peek();
            queue.poll();

            TreeNode tempNode = currentNode.left;
            currentNode.right = currentNode.left;
            currentNode.left = tempNode;


            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    public static TreeNode mirrorTreeRec(TreeNode node) {
       if(node == null)
           return null;

        TreeNode left = mirrorTreeRec(node.left);
        TreeNode right = mirrorTreeRec(node.right);
        node.left=right;
        node.right=left;
        return node;
    }

}
