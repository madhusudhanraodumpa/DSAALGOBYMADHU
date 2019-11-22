package com.org.learnby.tree;

import java.util.ArrayList;
import java.util.List;

public class BTDiameterOfTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //root.left.left.right=new TreeNode(8);
      //  root.left.left.right.left=new TreeNode(9);
        BTInOrder inOrder=new BTInOrder();
        List<Integer> list=new ArrayList<>();
       BTHeightOfTree btHeightOfTree=new BTHeightOfTree();
       System.out.println(diameterOfTree(root));


    }

    private static int diameterOfTree(TreeNode root) {
        if(root==null) return 0;
        int leftHeight=BTHeightOfTree.heightOfTree(root.left);
        int rightHeight=BTHeightOfTree.heightOfTree(root.right);
        int diaMeter=leftHeight+rightHeight+1;
        int leftDiaMeter=diameterOfTree(root.left);
        int rightDiaMeter=diameterOfTree(root.right);

        return Math.max(diaMeter,Math.max(leftDiaMeter,rightDiaMeter));









    }

}
