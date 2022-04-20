package com.org.learnby.tree;

public class BTLCAOfTwoNodes {
    private static int count=0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

           TreeNode node = lcaOfTwoNodesII(root, 2, 10);
           if(count==2) {
               System.out.println(node.data);
           }else {
            System.out.println("not found");
        }

    }

    private static TreeNode lcaOfTwoNodes(TreeNode root, int i, int j) {
        if(root == null) return null;
        if(root.data==i || root.data==j){
            return root;
        }

        TreeNode leftNode=lcaOfTwoNodes(root.left,i,j);
        TreeNode rightNode=lcaOfTwoNodes(root.right,i,j);

        if(leftNode!=null && rightNode!=null){
            return root;
        }
        return leftNode!=null?leftNode:rightNode;


    }

    private static TreeNode lcaOfTwoNodesII(TreeNode root, int i, int j) {
        if(root == null) return null;


        TreeNode leftNode=lcaOfTwoNodesII(root.left,i,j);
        TreeNode rightNode=lcaOfTwoNodesII(root.right,i,j);

        if(leftNode!=null && rightNode!=null){
            return root;
        }else if(root.data==i || root.data==j){
            count++;
            return root;
        } else if(leftNode==null && rightNode==null){
            return null;
        }
        return leftNode!=null?leftNode:rightNode;


    }
    private static TreeNode lcaOfTwoNodesDeepestLeaves(TreeNode root){
        if(root==null) return null;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        if(lh==rh) return root;
        if(lh>rh) return lcaOfTwoNodesDeepestLeaves(root.left);
        else return lcaOfTwoNodesDeepestLeaves(root.right);
    }
    private static int dfs(TreeNode root)
    {
        if(root==null) return 0;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        return Math.max(lh,rh)+1;
    }

}
