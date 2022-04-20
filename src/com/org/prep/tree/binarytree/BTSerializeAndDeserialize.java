package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

public class BTSerializeAndDeserialize {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);
        node.right.right.left = new TreeNode(7);
        System.out.println(serialize(node,""));
    }

    public static String serialize(TreeNode node,String str){
        if(node==null){
            str+="/,";
            return str;
        }
        if(node.left!=null || node.right!=null){
            str=str+node.data+"#,";
        }
        if(node.left==null && node.right==null){
           str=str+node.data+",";
           return str;
        }
        str =serialize(node.left,str);
        str = serialize(node.right,str);
        return str;
    }


}
