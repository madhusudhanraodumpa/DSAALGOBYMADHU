package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);

        root.left = new TreeNode(8);
        root.left.left= new TreeNode(3);
        root.left.right = new TreeNode(9);

        /*root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);
        System.out.println();
        inOrderIterative2ndWay(root);*/
        inOrderBSTSuxessorForAllNode(root,null);
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        while(root!=null || !st.isEmpty()){

            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                TreeNode node=st.peek().right;

                list.add(st.peek().data);
                st.pop();

                if(node!=null){
                    st.push(node);
                    root=node;
                }




            }



        }
        return list;
    }
    public static void inOrderIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            while (root != null) {
                root = root.left;
                if (root != null) {
                    s.push(root);
                }
            }

            TreeNode node = s.peek();
            s.pop();
            if (node.right != null) {
                s.push(node.right);
                root = node.right;

            }
            System.out.print(node.data + " ");
        }

    }

    private static void inOrderIterative2ndWay(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();

        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {

                if (s.isEmpty()) break;
                root = s.pop();
                System.out.print(root.data + " ");
                root = root.right;

            }
        }

    }

    //Left ,Root,Right
    public static void inOrderRecursive(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);

    }

    public static void inOrderBSTSuxessorForAllNode(TreeNode root,TreeNode next) {

        if (root == null) {
            return;
        }
        inOrderBSTSuxessorForAllNode(root.left,root);
        if(next!=null){
        System.out.println(root.data+" next value is "+next.data + " ");}
        else{
            System.out.println(root.data+" next value is -1 ");

        }
        inOrderBSTSuxessorForAllNode(root.right,root);

    }


}
