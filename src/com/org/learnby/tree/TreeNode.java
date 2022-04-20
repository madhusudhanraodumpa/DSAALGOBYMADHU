package com.org.learnby.tree;

public class TreeNode {
    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int data;
    public TreeNode left;
    public TreeNode right;
    int height;
    int size;

    public TreeNode(int data){
        this.left=null;
        this.right=null;
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
