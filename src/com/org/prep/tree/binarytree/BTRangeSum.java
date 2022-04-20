package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTRangeSum {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        System.out.println(rangeSumBST(root,7,15));



    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;

        if(root.data>=low  && root.data<=high){
            return root.data+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }

        if(root.data<low){
            return rangeSumBST(root.right,low,high);
        }
        if(root.data>high){
            return rangeSumBST(root.left,low,high);

        }
        return 0;
    }
}
