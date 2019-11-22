package com.org.learnby.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTReverseLevelOrder {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        reverseLevelOrder(root);

    }

    private static void reverseLevelOrder(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        Stack<TreeNode> s1=new Stack<>();
        q1.offer(root);
        while(!q1.isEmpty()){
            TreeNode current=q1.poll();
            s1.push(current);
            if(current.right!=null){
                q1.offer(current.right);
            }
            if(current.left!=null){
                q1.offer(current.left);
            }


        }
        while(!s1.isEmpty()){
            System.out.print(s1.pop().data+" ");
        }
        System.out.println();

    }
}
