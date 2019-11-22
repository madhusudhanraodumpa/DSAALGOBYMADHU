package com.org.learnby.tree;

import java.util.Stack;

public class BTPostOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        postOrderRecursive(root);
        System.out.println();
        postOrderIterative(root);
        System.out.println();
        postOrderIterative2ndWay(root);

    }
    // left,rigth, root
    public static void postOrderRecursive(TreeNode root){
        if(root==null)
            return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data+" ");
    }

    //Using two stacks
    public static void postOrderIterative(TreeNode root){
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        st1.push(root);
       if(root==null) return;
       while(!st1.isEmpty()){
           root=st1.pop();
           st2.push(root);
           if(root.left!=null){
               st1.push(root.left);
           }
           if(root.right!=null){
               st1.push(root.right);
           }

       }

           while(!st2.isEmpty()){
               System.out.print(st2.pop().data+" ");
           }

    }

    //Using single stack

    public static void postOrderIterative2ndWay(TreeNode root){
        TreeNode current=root;
        Stack<TreeNode> s=new Stack<>();

        while(current!=null || !s.isEmpty()){
            if(current!=null){
                s.push(current);
                current=current.left;
            }else{
                TreeNode temp=s.peek().right;
                if(temp==null){
                    temp=s.pop();
                    System.out.print(temp.data+" ");
                    while(!s.isEmpty() && s.peek().right==temp){
                        temp=s.pop();
                        System.out.print(temp.data+" ");
                    }


                }else{
                    current=temp;
                }

            }





        }



    }
}
