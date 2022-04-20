package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);


    }

    private static void inOrderRecursive(TreeNode root) {
        if (root == null) return;
        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);

    }

    private static List<Integer> inOrderIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                if (s.isEmpty()) break;
                root = s.pop();
                list.add(root.data);
                root = root.right;
            }


        }


        return list;
    }
}
