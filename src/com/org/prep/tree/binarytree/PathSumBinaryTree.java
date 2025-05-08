package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(1);
        System.out.println(hasPathSum(root,22,new ArrayList<>()));
    }
    public static boolean hasPathSum(TreeNode root, int k, List<Integer> path) {
        if(root==null) return false;
        k=k-root.data;
        path.add(root.data);
        if(root.left==null && root.right==null) {
            if (k == 0) {
                String pathString = path.stream().map(String::valueOf).collect(Collectors.joining(","));
                System.out.println(pathString);
                return true;

            }
        }
        boolean left = hasPathSum(root.left,k,path);
        boolean right= hasPathSum(root.right,k,path);
        path.remove(path.size()-1);
        return left||right;
     }

}
