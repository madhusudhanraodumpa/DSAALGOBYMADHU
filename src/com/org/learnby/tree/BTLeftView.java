package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLeftView {
    public static int maxLevel=Integer.MIN_VALUE;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.right=new TreeNode(8);
        root.left.left.right.left=new TreeNode(9);
        BTInOrder inOrder=new BTInOrder();
        List<Integer> list=new ArrayList<>();
        leftViewNodes(root,list);
        list.forEach(System.out::print);
        System.out.println();
        leftViewNodesRecursive(root,0);

    }


    private static void leftViewNodes(TreeNode root, List<Integer> list) {

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        list.add(root.data);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node!=null) {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if(node==null && q.isEmpty()){
                break;
            }
            if(node==null){
                list.add(q.peek().data);
                q.offer(node);
            }
        }

    }
    private static void leftViewNodesRecursive(TreeNode root, int level) {


        if(root==null) return;
        if(maxLevel<level){
            maxLevel=level;
            System.out.println(root.data+" ");
        }
        leftViewNodesRecursive(root.left,level+1);
        leftViewNodesRecursive(root.right,level+1);



    }

    }
