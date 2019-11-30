package com.org.learnby.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstrcutBTfromINOrderAndPreOrder {
    private static int preIndex = 0;
    public static void main(String args[]){

        int[] inorder={4,2,1,7,5,8,3,6};
        int[] preOrder={1,2,4,3,5,7,8,6};
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=constructBinaryTree(0,preOrder.length-1,preOrder,map);

        BTInOrder.inOrderRecursive(root);


    }

    private static TreeNode constructBinaryTree(int start, int end, int[] preOrder, Map<Integer, Integer> map) {
    if(start>end) return null;
    TreeNode root=new TreeNode(preOrder[preIndex]);
    preIndex++;
    if(start==end) return root;
    int index=map.get(root.data);
    root.left=constructBinaryTree(start,index-1,preOrder,map);
    root.right=constructBinaryTree(index+1,end,preOrder,map);
    return root;

    }

}
