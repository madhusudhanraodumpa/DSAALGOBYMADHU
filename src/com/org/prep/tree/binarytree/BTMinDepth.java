package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BTMinDepth {
    public static void main(String args[]){

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(4);
        node.right.right.right.right = new TreeNode(5);
        System.out.println(minDepthItr(node));
    }

    public static int minDepth(TreeNode node){
        if(node==null) return 0;
        if(node.left==null) return 1+minDepth(node.right);
        if(node.right==null) return 1+minDepth(node.left);
        return Math.min(minDepth(node.left),minDepth(node.right));
    }
    public static int minDepthItr(TreeNode root){

        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int depth=0;
        while (!queue.isEmpty()){
            int count = queue.size();
            depth++;
            while (count>0){
                TreeNode temp = queue.peek();
                queue.poll();
                count--;
                if(isLeaf(temp)) return depth;
                if(temp.left!=null) {
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }



        }
        return depth;
    }
    private static boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }
}
