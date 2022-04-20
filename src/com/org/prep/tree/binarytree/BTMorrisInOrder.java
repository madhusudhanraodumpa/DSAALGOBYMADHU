package com.org.prep.tree.binarytree;

import com.org.learnby.tree.BTInOrder;
import com.org.learnby.tree.TreeNode;

public class BTMorrisInOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);

        root.right = new TreeNode(16);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.right.right.right=new TreeNode(20);
        root.right.left.left = new TreeNode(12);
        root.right.left.left.left = new TreeNode(11);


        BTInOrder.inOrderRecursive(root);
        System.out.println();
       inOrderTraversal(root);



    }

    private static void inOrderTraversal(TreeNode root) {
        TreeNode curent=root;
        while (curent!=null){
            if(curent.left==null){
                System.out.print(curent.data+" ");
                curent=curent.right;
            }else{
            TreeNode predecessor= findPredecessor(curent);
            if(predecessor.right==null){
                predecessor.right=curent;
                System.out.print(curent.data+" ");
                curent=curent.left;
            }else{
                predecessor.right=null;
                curent=curent.right;
            }



            }



        }



    }
    private static TreeNode findPredecessor(TreeNode root){
        TreeNode predessor=root.left;

        while (predessor.right!=null && predessor.right!=root){
            predessor=predessor.right;
        }
        return predessor;

    }
}
