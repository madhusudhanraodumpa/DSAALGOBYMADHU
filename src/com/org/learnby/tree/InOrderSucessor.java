package com.org.learnby.tree;

public class InOrderSucessor {
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
        inOrderSucessor(root.left,1);



    }

    private static void inOrderSucessor(TreeNode root, int i) {
        Integer data=null;
        if(root.right!=null){
            TreeNode temp=root.right;
            while(root.left!=null){
                root=root.left;
            }
            System.out.println(temp.data);
        }else{

            while(root!=null && root.data!=i){
                if(root.data<i){
                    root=root.right;
                }else{
                    data=root.data;
                    root=root.left;
                }
            }
        System.out.println(data);

        }
    }
}
