package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.List;

public class BTMedianLevelOfTree {
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
        medianOfLevelOfTree(root,4,list);
        System.out.println(list.get(list.size()/2));


    }

    private static void medianOfLevelOfTree(TreeNode root,int level, List<Integer> list) {
        if(root==null) return;
        if(level==0){
            list.add(root.data);
        }
        medianOfLevelOfTree(root.left,level-1,list);
        medianOfLevelOfTree(root.right,level-1,list);
    }
}
