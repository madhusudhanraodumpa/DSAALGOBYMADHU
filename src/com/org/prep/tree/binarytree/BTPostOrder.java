package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        postOrderRecursive(root);
        System.out.println();
        postOrderIterative(root);
        postOrderIterative2ndWay(root);


    }

    private static void postOrderRecursive(TreeNode root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");

    }

    private static List<Integer> postOrderIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        Stack<TreeNode> s1 = new Stack();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            s1.push(current);

            if (current.left != null) {
                s.push(current.left);
            }
            if (current.right != null) {
                s.push(current.right);
            }
        }
        while (!s1.isEmpty()) {
            System.out.print(s1.peek().data + " ");

            list.add(s1.pop().data);
        }
        return list;
    }

    private static List<Integer> postOrderIterative2ndWay(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (current != null || !s.isEmpty()) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                TreeNode tempNode = s.peek().right;
                if (tempNode == null) {
                    tempNode = s.peek();
                    list.add(s.peek().data);
                    s.pop();
                    while (!s.isEmpty() && s.peek().right == tempNode) {
                        tempNode = s.pop();
                        list.add(tempNode.data);
                    }
                } else {
                    current = tempNode;
                }


            }


        }
        return list;

    }
}
