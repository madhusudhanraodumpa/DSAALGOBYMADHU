package com.org.learnby.tree;

public class BSTMedianofTree {
    public static void main(String args[]){
        TreeNode root=null;
        root=BSTOperations.insertNode(root,50);
        root=BSTOperations.insertNode(root,40);
        root=BSTOperations.insertNode(root,45);
        root=BSTOperations.insertNode(root,30);
        root=BSTOperations.insertNode(root,35);
        root=BSTOperations.insertNode(root,20);
        root=BSTOperations.insertNode(root,25);

        root=BSTOperations.insertNodeRecursive(root,60);
        root=BSTOperations.insertNodeRecursive(root,65);
        root=BSTOperations.insertNodeRecursive(root,70);
        root=BSTOperations.insertNodeRecursive(root,75);
        root=BSTOperations.insertNodeRecursive(root,80);
        root=BSTOperations.insertNodeRecursive(root,85);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        int countNodes=countOfNode(root);
        System.out.println(countNodes);
        System.out.println(findMedianOfBST(root,countNodes));
    }

    private static int findMedianOfBST(TreeNode root, int countNodes) {
        TreeNode temp=root;
        TreeNode previous=null;
        int countM= countNodes/2;
        boolean isEven= (countNodes & 1)==0?true:false;
        int count=0;
        while(temp!=null){
            if(temp.left==null){
               // System.out.print(temp.data+" ");
                if(countM==count){
                    if(isEven) return (previous.data+temp.data)/2;
                    else return temp.data;
                }
                previous=temp;
                ++count;
                temp=temp.right;
            }else {
                TreeNode predecessor = temp.left;

                while (predecessor.right != null && predecessor.right != temp) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = temp;
                    temp = temp.left;
                } else if (predecessor.right != null) {
                    predecessor.right = null;
                 //   System.out.print(temp.data + " ");
                    if(countM==count){
                        if(isEven) return (previous.data+temp.data)/2;
                        else return temp.data;
                    }
                    ++count;
                    previous=temp;
                    temp = temp.right;
                }

            }
        }

        return -1;


    }

    private static int countOfNode(TreeNode root) {

        TreeNode temp=root;
        int count=0;
        while(temp!=null){
            if(temp.left==null){
                System.out.print(temp.data+" ");
                ++count;
                temp=temp.right;
            }else {
                TreeNode predecessor = temp.left;

                while (predecessor.right != null && predecessor.right != temp) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = temp;
                    temp = temp.left;
                } else if (predecessor.right != null) {
                    predecessor.right = null;
                    System.out.print(temp.data + " ");
                    ++count;
                    temp = temp.right;
                }

            }
        }

        return count;


    }
}
