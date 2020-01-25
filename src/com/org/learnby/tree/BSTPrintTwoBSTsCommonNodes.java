package com.org.learnby.tree;

import java.util.Stack;

public class BSTPrintTwoBSTsCommonNodes {
    public static void main(String[] args){
        TreeNode root=null;
        root=BSTOperations.insertNode(root,5);
        root=BSTOperations.insertNode(root,12);
        root=BSTOperations.insertNode(root,10);
        root=BSTOperations.insertNode(root,0);
        root=BSTOperations.insertNode(root,4);
        root=BSTOperations.insertNode(root,7);
        root=BSTOperations.insertNode(root,9);

        TreeNode root1=null;

        root1=BSTOperations.insertNode(root1,12);
        root1=BSTOperations.insertNode(root1,7);
        root1=BSTOperations.insertNode(root1,20);
        root1=BSTOperations.insertNode(root1,4);
        root1=BSTOperations.insertNode(root1,9);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        BTInOrder.inOrderRecursive(root1);
        System.out.println();

        printCommonNodes(root,root1);


    }
    private static void printCommonNodes(TreeNode root1,TreeNode root2){
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        while(true){
            if(root1!=null || root2!=null) {
                if (root1 != null) {
                    s1.push(root1);
                    root1 = root1.left;
                }
                if (root2 != null) {
                    s2.push(root2);
                    root2 = root2.left;
                }
            }else{
                if(s1.isEmpty()|| s2.isEmpty()) break;
                TreeNode node1=s1.peek();
                TreeNode node2=s2.peek();

                if(node1.data==node2.data){
                    root1=s1.pop();
                    root2=s2.pop();
                    root1=root1.right;
                    root2=root2.right;
                    System.out.print(node1.data+" ");
                }else if(node1.data>node2.data){
                    root2=s2.pop();

                    root2=root2.right;
                    root1=null;
                } else if(node1.data<node2.data){
                    root1=s1.pop();
                    root1=root1.right;
                    root2=null;
                }
            }

        }




    }
}
