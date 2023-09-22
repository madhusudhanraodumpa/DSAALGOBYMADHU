package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;
import  java.util.*;

public class RecoverBST {
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);

        root.left.right = new TreeNode(2);
        recoverTree(root);
        
    }




    public static void recoverTree(TreeNode root) {
        inorderTraversal(root);
    }

    public static void inorderTraversal(TreeNode curr) {
        List<Integer> list=new ArrayList<>();
        TreeNode previous=null;
        TreeNode root=curr;
        while(root!=null){

            if(root.left==null){
                //list.add(root.data);
                if(previous==null){
                    previous=root;
                }
                else if( previous.data<root.data){
                    previous=root;
                }else{
                    TreeNode tempNode=root;
                    int temp=previous.data;
                    previous.data=root.data;
                    root.data=temp;
                    //previous=tempNode;;

                }
                root=root.right;
            }else{
                TreeNode prede=inorderPredecessor(root);
                if(prede.right==null){
                    prede.right=root;
                    root=root.left;
                }else{
                    prede.right=null;
                    if(previous==null){
                        previous=root;
                    }
                    else  if(previous.data<root.data){
                        previous=root;
                    }else{
                        TreeNode tempNode=root;
                        int temp=previous.data;
                        previous.data=root.data;
                        root.data=temp;
                      //  previous=tempNode;;

                    }
                    root=root.right;

                }

            }

        }
        //return curr;
    }

    public static TreeNode inorderPredecessor(TreeNode root){

        if(root.left==null) return null;

        TreeNode temp=root.left;
        while(temp.right!=null && temp.right!=root){
            temp=temp.right;
        }
        return temp;


    }
}
