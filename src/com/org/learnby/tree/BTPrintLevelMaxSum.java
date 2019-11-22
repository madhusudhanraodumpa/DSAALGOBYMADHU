package com.org.learnby.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTPrintLevelMaxSum {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BTInOrder inOrder=new BTInOrder();
        List<Integer> list=new ArrayList<>();
        printLevelMaxSum(root);
    }

    private static void printLevelMaxSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        q.offer(root);
        q.offer(null);
        int levelCount=-1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node!=null){
                sum=sum+node.data;

            }
            if(node!=null) {

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }else if(node==null && q.isEmpty()){
                if(sum>maxSum){
                    maxSum=sum;
                    levelCount++;
                }
                break;
            }else if(node==null){
                if(sum>maxSum){
                    maxSum=sum;
                    levelCount++;
                }
                q.offer(node);
                sum=0;
            }



        }
        System.out.println(maxSum);
        System.out.println(levelCount);
    }

}
