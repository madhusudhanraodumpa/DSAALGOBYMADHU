package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTPathSum {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        System.out.println(hasPathSum(root,18));



    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && targetSum-root.data==0) return true;

        return   hasPathSum(root.left,targetSum-root.data)||hasPathSum(root.right,targetSum-root.data);


    }
}
