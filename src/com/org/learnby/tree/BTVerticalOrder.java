package com.org.learnby.tree;


import java.util.*;

public class BTVerticalOrder {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        verticalOrder(root);

    }

    private static void verticalOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        Map<Integer, List<Integer>> map=new HashMap<>();
        q.offer(root);
        List<Integer> list=new ArrayList<>();
        list.add(root.data);
        int leftHd=0;
        int rigthHd=0;
        map.put(0,list);
        while(!q.isEmpty()){

            TreeNode node=q.poll();

            if(node.left!=null){
                leftHd=leftHd-1;
                List<Integer> leftList=map.get(leftHd);
                if(leftList!=null){
                    leftList.add(root.data);
                }else{
                    leftList=new ArrayList<>();
                    leftList.add(leftHd);
                }
                map.put(leftHd,leftList);

                q.offer(node.left);
            }
            if(node.right!=null){
                rigthHd=rigthHd+1;
                List<Integer> rigthList=map.get(rigthHd);
                if(rigthList!=null){
                    rigthList.add(rigthHd);
                }else{
                    rigthList=new ArrayList<>();
                    rigthList.add(rigthHd);
                }
                map.put(rigthHd,rigthList);

                q.offer(node.right);
            }

        }
        for(List<Integer> l:map.values()){
            for(Integer i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
