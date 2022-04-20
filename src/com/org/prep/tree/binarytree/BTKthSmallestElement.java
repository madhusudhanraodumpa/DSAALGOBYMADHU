package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.*;

public class BTKthSmallestElement {
    static List<Integer> list = new ArrayList<>();

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        Map<Integer, List<Integer>> map = new TreeMap<>();
        System.out.println(kthSmallest(root,1));
        System.out.println(kthSmallestItr(root,1));




    }

    public static int kthSmallestItr(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else {
                if(stack.isEmpty()) break;
                root=stack.pop();
                k=k-1;
                if(k==0) return root.data;
                root=root.right;

            }
        }






        return -1;
    }


        public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        smallest(root,list);
        return list.get(k-1);
    }

    public static void smallest(TreeNode root,List<Integer> list) {
        if(root==null) return;
        else{
            smallest(root.left,list);
            list.add(root.data);
            smallest(root.right,list);
        }
    }
    }
