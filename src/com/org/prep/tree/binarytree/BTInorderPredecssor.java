package com.org.prep.tree.binarytree;

import com.org.learnby.tree.BTInOrder;
import com.org.learnby.tree.TreeNode;

public class BTInorderPredecssor {
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
        System.out.println(inOrderPredecssor(root,9));



    }
    public static Integer inOrderPredecssor(TreeNode root,int element){
        Integer predecessor =null;
        while (root!=null){
            if(root.data>=element){
                root = root.left;
            }else {
                predecessor = root.data;
                root= root.right;
            }


        }


        return predecessor;

    }


}
