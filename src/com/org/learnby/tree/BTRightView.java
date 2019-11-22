package com.org.learnby.tree;

public class BTRightView {

    private static int maxLevel=Integer.MIN_VALUE;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left=new TreeNode(8);
        root.right.left.left.right=new TreeNode(9);
        rightView(root,0);


    }

    private static void rightView(TreeNode root, int level) {
        if(root==null) return;

        if(maxLevel<level){
            maxLevel=level;
            System.out.println(root.data+" ");
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);
    }
}
