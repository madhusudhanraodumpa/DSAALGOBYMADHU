package com.org.learnby.tree;


import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Map;

public class BTConstructLevelAndInOrder {
    static int levelIndex=0;
    public static void main(String[] args) {

        int in[]={4, 8, 10, 12, 14, 20, 22};
        int level[]={20, 8, 22, 4, 12, 10, 14};
        buildTree(in,level);
    }
    public static TreeNode buildTree(int[] inorder, int[] level) {
        Map<Integer,Integer> map= new HashMap<>();
        Map<Integer,Integer> levelMap= new HashMap<>();
        //Pair
        int n=inorder.length;
        for (int i=0;i<n;i++) {
            map.put(inorder[i],i);
            levelMap.put(level[i],i);
        }
        TreeNode root = buildTree(inorder,level,0,n-1,map,levelMap);
        BTInOrder.inOrderIterative(root);

        return root;
    }
    public static  TreeNode buildTree(int[] inorder, int[] level, int start, int end, Map<Integer,Integer> map,Map<Integer,Integer> levelMap) {
        if(start>end) return null;
            int inIndex=start;
            for (int i = start+1; i <= end; i++) {
                if (levelMap.get(inorder[i])<levelMap.get(inorder[inIndex])){
                    levelIndex=i;
                }
            }

        TreeNode root= new TreeNode(inorder[inIndex]);
        if(start==end) return root;

        root.left = buildTree(inorder,level,start,inIndex-1,map,levelMap);
        root.right = buildTree(inorder,level,inIndex+1,end,map,levelMap);
        return root;

    }
}
