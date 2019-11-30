package com.org.learnby.tree;

public class BTInOrderPredecessor {

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
        inOrderPredecssor(root.left,1);



    }

    private static void inOrderPredecssor(TreeNode root, int element) {
        Integer data=null;
        if(root.left!=null){
            TreeNode temp=root.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            System.out.println(temp.data);
        }else{
            while(root!=null && !(root.data==element))
            if(root.data<element){
                data=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
            System.out.println(data);


        }
    }
}
