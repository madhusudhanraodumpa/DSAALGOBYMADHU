package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class EqualTree {

    boolean flag=false;
    long totalSum=0;


    public static void main(String args[]){

    }

    public boolean equalsPartion1(TreeNode root){
        Map<TreeNode,Long> map=new HashMap<>();
        long sum=totalSum(root,map);
        if(sum%2==1) return false;

        for(Map.Entry<TreeNode, Long> entry: map.entrySet()){

            TreeNode temp=entry.getKey();
            Long val=entry.getValue();

            if(temp!=root && sum-val==val){
                return true;
            }
        }

        //totalSum=sum;
        ////   totalSumTree(root,null);
        return  flag;
    }


    public long totalSum(TreeNode A,Map<TreeNode,Long> map){
        if(A==null) return 0;

        long sum=A.data+totalSum(A.left,map)+totalSum(A.right,map);
        map.put(A,sum);
        return sum;

    }

}
