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
        Map<Integer, List<Integer>> map=new HashMap<>();
        verticalOrderRecursive(root,0,map);
System.out.println();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
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
                    leftList.add(node.left.data);
                }else{
                    leftList=new ArrayList<>();
                    leftList.add(node.left.data);
                }
                map.put(leftHd,leftList);

                q.offer(node.left);
            }
            if(node.right!=null){
                rigthHd=rigthHd+1;
                List<Integer> rigthList=map.get(rigthHd);
                if(rigthList!=null){
                    rigthList.add(node.right.data);
                }else{
                    rigthList=new ArrayList<>();
                    rigthList.add(node.right.data);
                }
                map.put(rigthHd,rigthList);

                q.offer(node.right);
            }

        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }

    }
    private static void verticalOrderRecursive(TreeNode root,int hd,Map<Integer, List<Integer>> map) {

        if(root ==null) return;
        List<Integer> list=map.get(hd);
        if(list!=null){
            list.add(root.data);
        }else{
            list=new ArrayList<>();
            list.add(root.data);
        }
        map.put(hd,list);
        verticalOrderRecursive(root.left,hd-1,map);
        verticalOrderRecursive(root.right,hd+1,map);
    }

    }
