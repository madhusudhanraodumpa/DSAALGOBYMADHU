package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTIsSameTree {

    public static void main(String args[]){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);
        //node1.right.right = new TreeNode(7);
        System.out.println(isSameTree(node,node1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null) return true;
        if(p!=null && q!=null){

            return p.data == q.data && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
