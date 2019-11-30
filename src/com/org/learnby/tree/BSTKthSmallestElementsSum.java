package com.org.learnby.tree;

import java.util.Stack;

public class BSTKthSmallestElementsSum {
    public static void main(String args[]){
        TreeNode root=null;
        root=BSTOperations.insertNodeRecursive(root,60);
        root=BSTOperations.insertNodeRecursive(root,65);
        root=BSTOperations.insertNodeRecursive(root,70);
        root=BSTOperations.insertNodeRecursive(root,75);
        root=BSTOperations.insertNodeRecursive(root,80);
        root=BSTOperations.insertNodeRecursive(root,85);
      //  System.out.println(findKthSmallestSumElements(root,3,0));
        findKthSmallestSumElementsUsingStack(root,3);

    }

    private static int findKthSmallestSumElements(TreeNode root, int k, int count) {
        if(root==null) return 0;
        if(count>k){
            return 0;
        }
        int sum=findKthSmallestSumElements(root.left,k,count);
        if(count>=k) return sum;
        sum=sum+root.data;
        ++count;
        if(count>k) return sum;

        return sum+findKthSmallestSumElements(root.right,k,count);
    }
    private static void findKthSmallestSumElementsUsingStack(TreeNode root, int k) {

       Stack<TreeNode> st=new Stack<>();
       int sum=0;
       while(true){
           if(root!=null) {
                   st.push(root);
                   root = root.left;

           }else{
               if(st.isEmpty()) break;
               root=st.pop();
               if(k>0){
                   sum=sum+root.data;
                   --k;
               }else{
                   break;
               }
               System.out.print(root.data+" ");
               root=root.right;

           }


       }
       System.out.println(sum);
    }

}
