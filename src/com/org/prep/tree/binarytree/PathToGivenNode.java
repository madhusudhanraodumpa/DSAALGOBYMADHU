package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathToGivenNode {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        int[] ans = solve(node,5);

    }

    static List<Integer> l;
    public static int[] solve(TreeNode A, int B) {
        List<Integer> list=new ArrayList<>();
        path(A,B,list);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void path(TreeNode A, int B,List<Integer> list) {
        if(A==null) return;
        list.add(A.data);
        if(A.data==B){
            l= new ArrayList<>(list);
        }
        path(A.left,B,list);
        path(A.right,B,list);

        list.remove(list.size()-1);

    }
}
