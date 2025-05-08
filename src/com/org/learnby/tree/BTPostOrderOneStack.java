package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrderOneStack {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        postorderTraversal(root);
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty()) {

            if(root!=null) {
                st.push(root);
                root=root.left;
            } else {
                TreeNode temp = st.peek().right;
                if(temp==null) {
                    temp=st.peek();
                    st.pop();
                    ans.add(temp.data);
                    while(!st.isEmpty() &&  temp==st.peek().right) {
                        temp=st.peek();
                        st.pop();
                        ans.add(temp.data);
                    }

                }else{
                    root=temp;
                }
            }


        }

        return ans;
    }
}
