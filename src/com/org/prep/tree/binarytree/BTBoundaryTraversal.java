package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BTBoundaryTraversal {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        boundaryTraversal(root);



    }

    private static List<Integer> boundaryTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        list.add(root.data);
        if(root.left==null && root.right==null) return list;
        LB(root.left,list);


        Leafs(root,list);
        RB(root.right,list);
        return list;


    }
    public static void LB(TreeNode node, List<Integer> list){
        if(node==null) return;
        if(node.left!=null){
            list.add(node.data);
            LB(node.left,list);
        }
        else if(node.right!=null){
            list.add(node.data);
            LB(node.right,list);
        }

    }

    public static void RB(TreeNode node, List<Integer> list){
        if(node==null) return;

        if(node.right!=null){

            RB(node.right,list);
            list.add(node.data);
        }
        else if(node.left!=null){

            RB(node.left,list);
            list.add(node.data);
        }

    }
    public static void Leafs(TreeNode node, List<Integer> list){
        if(node==null) return;

        if(node.left!=null){
            Leafs(node.left,list);
        }
        if(node.left==null && node.right==null){
            list.add(node.data);
        }
        if(node.right!=null){
            Leafs(node.right,list);
        }

    }
}
