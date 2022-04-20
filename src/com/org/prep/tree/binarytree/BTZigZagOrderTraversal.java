package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.*;

public class BTZigZagOrderTraversal {
    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        zigzagLevelOrder(node);
    }


    public static void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.data);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.data);
            else
                results.get(level).add(0, node.data);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }

    public static List<List<Integer>> levelOrder(TreeNode node) {

        List<List<Integer>> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();

        if (node == null) return list;
        else {
            stack.add(node);
        }

        while (true) {
            if (!stack.isEmpty()) {
                List<Integer> stackList= new ArrayList<>();
                while (!stack.isEmpty()) {

                    TreeNode tempNode = stack.peek();
                    stackList.add(tempNode.data);
                    stack.pop();
                    if (tempNode.left != null) {
                        stack1.push(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        stack1.push(tempNode.right);
                    }
                }
                list.add(stackList);
            } else {
                List<Integer> stackList1= new ArrayList<>();

                while (!stack1.isEmpty()) {
                    TreeNode tempNode = stack1.peek();
                    stackList1.add(tempNode.data);

                    stack1.pop();

                    if (tempNode.right != null) {
                        stack.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        stack.push(tempNode.left);
                    }

                }
                list.add(stackList1);
            }
        }


    }
}
