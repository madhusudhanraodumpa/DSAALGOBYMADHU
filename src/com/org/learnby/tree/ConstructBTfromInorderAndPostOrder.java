package com.org.learnby.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromInorderAndPostOrder {
    public static void main(String args[]){
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.right=new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        BTPostOrder.postOrderRecursive(root);*/
        int in[]={4,8,2,5,1,6,3,7};
        int post[]={8,4,5,2,6,7,3,1};
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        TreeNode root=constructBT(0,post.length-1,in,post,map,in.length-1);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        BTPostOrder.postOrderRecursive(root);

    }

    private static TreeNode constructBT(int start,int end,int[] in, int[] post, Map<Integer, Integer> map,int postIndex) {
        if(start>end) return null;
        if(postIndex<0) return null;

        TreeNode root=new TreeNode(post[postIndex]);

        postIndex--;
        if(start==end) return root;
        int index=map.get(root.data);
        root.right=constructBT(index+1,end,in,post,map,postIndex);
        root.left=constructBT(start,index-1,in,post,map,postIndex);
        return root;



    }
}
