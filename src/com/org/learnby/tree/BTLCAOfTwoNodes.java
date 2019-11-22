package com.org.learnby.tree;

public class BTLCAOfTwoNodes {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(lcaOfTwoNodes(root,1,2).data);

    }

    private static TreeNode lcaOfTwoNodes(TreeNode root, int i, int j) {
        if(root == null) return null;
        if(root.data==i || root.data==j){
            return root;
        }

        TreeNode leftNode=lcaOfTwoNodes(root.left,i,j);
        TreeNode rightNode=lcaOfTwoNodes(root.right,i,j);

        if(leftNode!=null && rightNode!=null){
            return root;
        }
        return leftNode!=null?leftNode:rightNode;


    }

}
