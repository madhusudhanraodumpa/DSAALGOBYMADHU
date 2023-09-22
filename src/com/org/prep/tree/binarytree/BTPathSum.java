package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.*;

public class BTPathSum {
    static List<List<Integer>> list=new ArrayList<>();
    static int count=0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);




        root.right.right = new TreeNode(11);


        Map<Integer, List<Integer>> map = new TreeMap<>();
        int list = pathSumII(root,8);
        System.out.println(list);


    }

    public static int pathSumII(TreeNode root,int k){
        pathSumHelper(root,k);
        return count;
    }
    public static void pathSumHelper(TreeNode root, int k) {
        if(root==null){
            return;
        }

        if(k==0) {
            count++;
        }



        pathSumHelper(root,k-root.data);

      //  pathSumHelper(root.right,k-root.data);
        pathSumHelper(root.left,k);
        pathSumHelper(root.right,k);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> l=new ArrayList<>();
        pathSumHelper(root,targetSum,l);
        return list;
    }

    public static void pathSumHelper(TreeNode root, int k,List<Integer> l) {

        if(root==null) return;
        k=k-root.data;
        l.add(root.data);

        if(root.left==null && root.right==null){
            if(k==0) { list.add(new ArrayList<>(l));}
        }else{
            pathSumHelper(root.left,k,l);
            pathSumHelper(root.right,k,l);
        }
        l.remove(l.size()-1);

    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && targetSum-root.data==0) return true;

        return   hasPathSum(root.left,targetSum-root.data)||hasPathSum(root.right,targetSum-root.data);


    }
}
