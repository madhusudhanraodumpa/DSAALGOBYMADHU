package com.org.learnby.tree;

import java.util.*;

public class BTLCAOfTwoNodes {
    private static int count=0;
    static List<List<Integer>> l=new ArrayList<>();
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);

        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);


        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
            List<Integer> l1=new ArrayList<>();
         //  LCA(root, 7, l1);
       // TreeNode node =lowestCommonAncestor(root, root.left,root.left.right.right);
        System.out.println(Long.MIN_VALUE);
    }
   static int T=0;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        Map<TreeNode,Integer> in=new HashMap<>();
        Map<TreeNode,Integer> out=new HashMap<>();
        inAndOutTimeOfTree(root,in,out);
        TreeNode current=root;
        while(current!=null){
            if(in.get(current.left)<=in.get(p) && out.get(current.left)>=out.get(p)
                    &&   in.get(current.left)<=in.get(q) && out.get(current.left)>=out.get(q)){
                current=current.left;
            }
            else  if(in.get(current.right)<=in.get(p) && out.get(current.right)>=out.get(p)
                    &&   in.get(current.right)<=in.get(q) && out.get(current.right)>=out.get(q)){
                current=current.right;
            }else{
                return current;
            }

        }

        return null;

    }
    public static void inAndOutTimeOfTree(TreeNode root,Map<TreeNode,Integer> in,Map<TreeNode,Integer> out){

        if(root==null) return;
        in.put(root,T);
        T++;
        inAndOutTimeOfTree(root.left,in,out);
        inAndOutTimeOfTree(root.right,in,out);
        out.put(root,T);
        T++;


    }

    public static void LCA(TreeNode root, int node, List<Integer> list) {

        if(root==null) return;
        list.add(root.data);
        if(root.data==node){
            l.add(new ArrayList<>(list));
        }else{

            LCA(root.left,node,list);
            LCA(root.right,node,list);
        }
        list.remove(list.size()-1);

    }

    private static TreeNode lcaOfTwoNodes(TreeNode root, int i, int j) {
        if(root == null) return null;
        if(root.data==i || root.data==j){
            return root;
        }

        TreeNode leftNode=lcaOfTwoNodes(root.left,i,j);
        TreeNode rightNode=lcaOfTwoNodes(root.right,i,j);

        if(leftNode!=null && rightNode!=null){
            return root;
        }
        return leftNode!=null?leftNode:rightNode;


    }

    private static TreeNode lcaOfTwoNodesII(TreeNode root, int i, int j) {
        if(root == null) return null;


        TreeNode leftNode=lcaOfTwoNodesII(root.left,i,j);
        TreeNode rightNode=lcaOfTwoNodesII(root.right,i,j);

        if(leftNode!=null && rightNode!=null){
            return root;
        }else if(root.data==i || root.data==j){
            count++;
            return root;
        } else if(leftNode==null && rightNode==null){
            return null;
        }
        return leftNode!=null?leftNode:rightNode;


    }
    private static TreeNode lcaOfTwoNodesDeepestLeaves(TreeNode root){
        if(root==null) return null;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        if(lh==rh) return root;
        if(lh>rh) return lcaOfTwoNodesDeepestLeaves(root.left);
        else return lcaOfTwoNodesDeepestLeaves(root.right);
    }
    private static int dfs(TreeNode root)
    {
        if(root==null) return 0;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        return Math.max(lh,rh)+1;
    }

}
