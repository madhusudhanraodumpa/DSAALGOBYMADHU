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

        verticalOrderTraversal(root);

        List<List<Integer>> lists= new ArrayList<>();

        Map<Integer,List<Integer>> map = new HashMap<>();

        verticalOrder(root,0,map);
        for(int i =minColumn;i<=maxColumn;i++){
            lists.add(map.get(i));
        }
        System.out.println();


    }

    public static int[][] verticalOrderTraversal(TreeNode A) {

        //  Pair<Integer,TreeNode> pair=new Pair<>();

        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        Pair pair=new Pair(0,A);
        q.add(pair);
        int maxlevel=0;
        int minLevel=0;


        while(q.size()>0){
            pair=q.peek();
            q.poll();

            TreeNode node=pair.getNode();
            int level=pair.getLevel();
            maxlevel=Math.max(maxlevel,level);
            minLevel=Math.min(minLevel,level);


            if(map.containsKey(level)){
                List<Integer> x=map.get(level);
                x.add(node.data);
                map.put(level,x);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(node.data);
                map.put(level,list);
            }

            Pair p=null;

            if(node.left!=null){
                p=new Pair(level-1,node.left);
                q.add(p);
            }
            if(node.right!=null){
                p=new Pair(level+1,node.right);
                q.add(p);
            }
        }
        List<List<Integer>> l1=new ArrayList<>();

        for(int i=minLevel;i<=maxlevel;i++){

            l1.add(map.get(i));
        }


        return l1.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);









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
class Pair{
    private int level;
    private TreeNode node;
    Pair(int level,TreeNode node){
        this.level=level;
        this.node=node;
    }

    public TreeNode getNode(){
        return this.node;
    }
    public int getLevel(){
        return this.level;
    }



}
