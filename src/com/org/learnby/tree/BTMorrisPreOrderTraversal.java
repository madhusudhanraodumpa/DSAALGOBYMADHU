package com.org.learnby.tree;

public class BTMorrisPreOrderTraversal {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        morrisPreOrder(root);
    }

    private static void morrisPreOrder(TreeNode root) {
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                System.out.print(temp.data+" ");
                temp=temp.right;
               }else{
                TreeNode predecessor=temp.left;
                while(predecessor.right!=null && predecessor.right!=temp){
                    predecessor=predecessor.right;
                }
                if(predecessor.right==null){
                    predecessor.right=temp;
                 //   System.out.print(temp.data+" ");
                    temp=temp.left;
                }else{
                    predecessor.right=null;
                    System.out.print(temp.data+" ");
                    temp=temp.right;
                }


            }


        }
    }
}
