package com.org.learnby.tree;

public class BTMirrorView {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BTInOrder inOrder=new BTInOrder();
        inOrder.inOrderRecursive(root);
        System.out.println();
        TreeNode node=mirrorView(root);
        inOrder.inOrderRecursive(node);
    }

    private static TreeNode mirrorView(TreeNode root) {
        if(root==null) return null;
        TreeNode left=mirrorView(root.left);
        TreeNode right=mirrorView(root.right);
        /*TreeNode tempNode=null;
        tempNode=left;
        root.right=left;
        root.left=tempNode;*/

        root.left=right;
        root.right=left;
        return root;
    }
}
