package com.org.learnby.tree;


import java.util.Stack;

public class BTPreOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preOrderRecursive(root);
        System.out.println();
        preOrderIterative(root);


    }

    private static void preOrderRecursive(TreeNode root) {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    private static void preOrderIterative(TreeNode root){
        Stack<TreeNode> s=new Stack();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode current=s.pop();
            System.out.print(current.data+" ");
            if(current.right!=null){
                s.push(current.right);
            }
            if(current.left!=null){
                s.push(current.left);
            }
        }

    }
}
