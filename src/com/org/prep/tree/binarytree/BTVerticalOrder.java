package com.org.prep.tree.binarytree;

import com.org.learnby.tree.BTHeightOfTree;
import com.org.learnby.tree.BTInOrder;
import com.org.learnby.tree.TreeNode;

import java.util.*;

public class BTVerticalOrder {
   static int minColumn=0;
    static int maxColumn =0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists= new ArrayList<>();

        Map<Integer,List<Integer>> map = new HashMap<>();

        verticalOrder(root,0,map);
        for(int i =minColumn;i<=maxColumn;i++){
            lists.add(map.get(i));
        }
        System.out.println();


    }

    private static void verticalOrder(TreeNode root, int dist, Map<Integer,List<Integer>> map) {

        if(root==null) return;

        List<Integer> list = map.get(dist);
        if(list==null){
            list = new LinkedList<>();
            list.add(root.data);
        }else{
            list.add(root.data);
        }
        minColumn = Math.min(minColumn,dist);
        maxColumn = Math.max(maxColumn,dist);
        map.put(dist,list);

        verticalOrder(root.left,dist-1,map);
        verticalOrder(root.right,dist+1,map);


    }
}
