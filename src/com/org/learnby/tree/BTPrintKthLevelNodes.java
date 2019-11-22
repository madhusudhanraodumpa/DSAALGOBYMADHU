package com.org.learnby.tree;

public class BTPrintKthLevelNodes {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BTInOrder inOrder=new BTInOrder();
       printKthLevelNode(root,1);
    }

    private static void printKthLevelNode(TreeNode root, int k) {
        if(root==null) return ;
        if(k==0){
            System.out.print(root.data+" ");
        }
        printKthLevelNode(root.left,k-1);
        printKthLevelNode(root.right,k-1);
    }
}
