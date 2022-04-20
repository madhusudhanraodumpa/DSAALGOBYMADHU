package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTSumoFLeftLeafs {
    static int result=0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        System.out.println(sumOfLeftLeaves(root));



    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        if(root.left!=null && (root.left.left==null && root.left.right==null)){
            result=result+root.left.data;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;


    }
}
