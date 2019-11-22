package com.org.learnby.tree;

public class BTFindLastNodeOfCompleteTree {
    private static int maxLevel=Integer.MIN_VALUE;
    private static Integer lastNode=null;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        findLastNodeCompleteBinaryTree(root,0);
        System.out.println(lastNode);
    }

    private static void findLastNodeCompleteBinaryTree(TreeNode root, int level) {

        if(root ==null) return;

        if(maxLevel<level){
            maxLevel=level;
            lastNode=root.data;
        }
        findLastNodeCompleteBinaryTree(root.right,level+1);
        findLastNodeCompleteBinaryTree(root.left,level+1);
    }
}
