package com.org.learnby.tree;

public class BTHeightOfTree {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(heightOfTree(root));

    }

    public static int heightOfTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight=heightOfTree(root.left);
        int rightHeight=heightOfTree(root.right);
        return Integer.max(leftHeight,rightHeight)+1;
    }
}
