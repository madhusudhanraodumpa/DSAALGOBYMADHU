package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String args[]){

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
       // node.left.left = new TreeNode(4);
        //node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        levelOrder1(node);


    }
    public static List<List<Integer>> levelOrder1(TreeNode A) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        q.add(A);
        q.add(null);
        List<Integer> l=new ArrayList<>();
        while(q.size()>1){
            TreeNode f=q.peek();
            q.poll();

            if(f==null){
                list.add(l);
                l=new ArrayList<>();
                q.add(null);
            }else{
                l.add(f.data);
                if(f.left!=null){
                    q.add(f.left);
                }
                if(f.right!=null){
                    q.add(f.right);
                }

            }
        }

        return list;




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
