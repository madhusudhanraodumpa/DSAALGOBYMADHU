package com.org.learnby.tree;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.HashMap;
import java.util.Map;

public class ConstrcutBTfromPostOrderAndPreOrder {
    private static int preIdx = 0, postIdx = 0;
    private static int pIndex=0;
    public static void main(String args[]) {
        int pre[] = new int[]{1,2,4,5,3,6,7};
        int post[] = new int[]{4,5,2,6,7,3,1};
        int n = post.length;
        //TreeNode root = buildTree(pre, post);
       // BTInOrder.inOrderRecursive(root);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<post.length;i++){
            map.put(post[i],i);
        }
        construct(0,pre.length-1,pre,map);
    }
    public static TreeNode construct(int postStart, int postEnd,int[] pre,Map<Integer,Integer> map){
        if(postStart>postEnd) return null;
        TreeNode node = new TreeNode(pre[pIndex]);
        pIndex++;
        if(postStart==postEnd) return node;
        int postIndex = map.get(pre[pIndex]);

        node.left = construct(postStart,postIndex,pre,map);
        node.right = construct(postIndex+1,postEnd-1,pre,map);
        return node;


    }

    private static TreeNode buildTree(int[] pre, int[] post) {

        TreeNode node = new TreeNode(pre[preIdx++]);
        if (node.data != post[postIdx]) {
            node.left = buildTree(pre, post);
        }
        if (node.data != post[postIdx]) {
            node.right = buildTree(pre, post);
        }
        postIdx++;
        return node;

    }

    private static TreeNode buildTreeRec(int[] pre, int preStart, int preEnd, int postStart, int postEnd, Map<Integer,Integer> map) {
            if(preStart>postEnd) return null;
            TreeNode node = new TreeNode(pre[preStart]);
            if(preStart==preEnd) return node;
            int postIndex= map.get(pre[preStart+1]);
            int len = postIndex-preStart+1;
            node.left = buildTreeRec(pre,preStart+1,preStart+len,postStart,postIndex,map);
            node.right = buildTreeRec(pre,preStart+len+1,preEnd,postIndex+1,postEnd-1,map);
            return node;


    }


}
