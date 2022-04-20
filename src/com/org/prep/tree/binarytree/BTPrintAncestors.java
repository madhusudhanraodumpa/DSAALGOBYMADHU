package com.org.prep.tree.binarytree;

import com.org.learnby.tree.TreeNode;

import java.util.Stack;

public class BTPrintAncestors {
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(printAncestors(node,7));
        System.out.println(printAncestorsItr(node,7));

    }
    public static boolean printAncestors(TreeNode node, int data){

        if(node==null) return false;
        if(node.data==data) return true;

        if(printAncestors(node.left,data)||printAncestors(node.right,data)){
            System.out.println(node.data);
            return true;
        }

    return false;
    }

    public static boolean printAncestorsItr(TreeNode node, int data){

        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=node;
        while (true) {
            while (current != null && current.data != data) {
                stack.push(current);
                current = current.left;
            }
            if(current!=null && current.data==data) break;

            TreeNode tempNode= stack.peek().right;
            if(tempNode==null){
                tempNode=stack.peek();
                stack.pop();
                while (!stack.isEmpty()&&tempNode==stack.peek().right){
                    tempNode = stack.peek();
                    stack.pop();
                }


            }else {
                current=tempNode;
            }

        }
        while (!stack.isEmpty()){
            System.out.println(stack.peek().data);
            stack.pop();
        }

    return true;

    }

}
