package com.org.learnby.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BTLevelOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
       //levelOrder1stWay(root);
        levelOrder2ndWay(root);
    }
    //Using 1 queue
    public static void levelOrder2ndWay(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        q1.offer(root);
        q1.offer(null);
        TreeNode node=null;
        while(!q1.isEmpty()){
            node=q1.poll();
            if(node!=null){
                System.out.print(node.data+" ");
                if(node.left!=null){
                    q1.offer(node.left);
                }
                if(node.right!=null){
                    q1.offer(node.right);
                }
            }
            if(node==null && q1.isEmpty()){
                break;
            }else{
                if(node==null){
                    System.out.println();
                    q1.offer(node);
                }
            }

        }

    }

        //using 2 queues
    public static void levelOrder1stWay(TreeNode root){

        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.offer(root);
        TreeNode node=null;
        while(true){
            if(q1.isEmpty() && q2.isEmpty()){
                break;
            }
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    node = q1.poll();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        q2.offer(node.left);
                    }
                    if (node.right != null) {
                        q2.offer(node.right);
                    }
                }
                System.out.println();
            }else if(!q2.isEmpty()){
                while(!q2.isEmpty()){
                    node=q2.poll();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        q1.offer(node.left);
                    }
                    if (node.right != null) {
                        q1.offer(node.right);
                    }
                }
                System.out.println();
            }



        }


    }
}
