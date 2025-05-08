package com.org.learnby.tree;

import java.util.*;

public class BTAverageOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        //st.pop()
        //preorderTraversal(root,ans);
        //return ans;
        while(!st.isEmpty()) {
            TreeNode temp = st.peek();
            ans.add(temp.data);
            st.pop();
            if (temp.left != null) {
                st.add(temp.left);
            }
            if (temp.right != null) {
                st.add(temp.right);
            }
        }
        //averageOfLevels(root);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.
        q.add(root);
        q.add(null);
        int count = q.size()-1;
        int sum=0;
        while(!q.isEmpty() && q.peek()!=null) {

            TreeNode temp = q.remove();
            sum= sum+temp.data;
            if(temp!=null) {
                System.out.print(temp.data+" ");
                if(temp.left!=null) {
                    q.add(temp.left);
                }
                if(temp.right!=null) {
                    q.add(temp.right);
                }
            }
            if(q.peek()==null) {
                double avg = sum/count;
                ans.add(avg);
                System.out.println();
                q.remove();
                q.add(null);
                count=q.size()-1;
                sum=0;
            }


        }
        return ans;

    }
}
