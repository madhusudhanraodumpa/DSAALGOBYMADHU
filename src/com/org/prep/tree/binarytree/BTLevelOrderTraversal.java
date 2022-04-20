package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String args[]){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);


    }
    public static List<List<Integer>> levelOrder(TreeNode node){

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(node==null) return list;
        else{
            queue.add(node);
        }
        while (true){
            if(queue.isEmpty()) return list;
            int count = queue.size();


            List<Integer> innerList = new ArrayList<>();
            while (count>0){
                TreeNode tempNode = queue.peek();
                queue.poll();
                innerList.add(tempNode.data);

                if(tempNode.left!=null){
                    queue.add(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.add(tempNode.right);
                }
                count--;

            }
            list.add(innerList);

        }
    }
}
