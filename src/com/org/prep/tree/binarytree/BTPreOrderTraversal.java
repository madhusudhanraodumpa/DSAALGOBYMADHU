package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreOrderTraversal {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        printPreOrder(node);
        System.out.println();
        printPreOrderItr(node);
    }

    public static void printPreOrder(TreeNode node) {
        if(node==null) return;
        System.out.print(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);

    }

    public static List<Integer> printPreOrderItr(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if(node==null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode tempNode = stack.peek();
            System.out.print(tempNode.data+" ");
            list.add(tempNode.data);
            stack.pop();
            if(tempNode.right!=null) {
                stack.push(tempNode.right);
            }
            if(tempNode.left!=null) {
                stack.push(tempNode.left);
            }
        }
        return list;

    }

}
