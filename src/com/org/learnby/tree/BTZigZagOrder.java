package com.org.learnby.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTZigZagOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        zigZagOrder(root);
        System.out.println("============================================");
        zigZagOrder1stWay(root);
    }

    private static void zigZagOrder1stWay(TreeNode root) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    TreeNode node=s1.pop();
                    System.out.print(node.data+" ");
                    if(node.left!=null){
                        s2.push(node.left);
                    }
                    if(node.right!=null){
                        s2.push(node.right);
                    }
                }
                System.out.println();
            }else{
                while(!s2.isEmpty()){
                    TreeNode node=s2.pop();
                    System.out.print(node.data+" ");

                    if(node.right!=null){
                        s1.push(node.right);
                    }
                    if(node.left!=null){
                        s1.push(node.left);
                    }
                }
                System.out.println();
            }



        }


    }

        // its failing
    private static void zigZagOrder(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        int count=1;
        q1.offer(root);
        q1.offer(null);
        while(!q1.isEmpty()){
            TreeNode node=q1.poll();
            if(node!=null) {
                System.out.print(node.data+" ");
                if ((count & 1) == 1) {
                    if (node.right != null) {
                        q1.offer(node.right);
                    }
                    if (node.left != null) {
                        q1.offer(node.left);
                    }
                } else {
                    if (node.left != null) {
                        q1.offer(node.left);
                    }
                    if (node.right != null) {
                        q1.offer(node.right);
                    }
                }
            }
                else if(node == null && q1.isEmpty() ){
                    break;
                }
                else if(node==null){
                    count++;
                    System.out.println();
                    q1.offer(node);
                }

            }

        }




    }


