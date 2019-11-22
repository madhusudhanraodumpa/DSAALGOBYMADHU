package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BTPrintLeafToPathNodes {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right=new TreeNode(8);
        root.left.left.right.left=new TreeNode(9);
        BTInOrder inOrder=new BTInOrder();
        List<Integer> list=new ArrayList<>();
        printLeafToPathNodes(root,list);
    }

    private static void printLeafToPathNodes(TreeNode root,List<Integer> list) {
        if(root==null) return;
        list.add(root.data);

        if(root.left==null && root.right==null){
            printList(list);
            System.out.println();

        }
        printLeafToPathNodes(root.left,list);
        printLeafToPathNodes(root.right,list);
        list.remove(new Integer(root.data));

    }

    private static void printList(List<Integer> list) {
        list.forEach(System.out::print);
    }
}
