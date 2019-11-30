package com.org.learnby.tree;

public class BSTOperations {
    public static void main(String args[]){
        TreeNode root=null;
                root=insertNode(root,50);
                root=insertNode(root,40);
                root=insertNode(root,45);
        root=insertNode(root,30);
        root=insertNode(root,35);
        root=insertNode(root,20);
        root=insertNode(root,25);

        root=insertNodeRecursive(root,60);
        root=insertNodeRecursive(root,65);
        root=insertNodeRecursive(root,70);
        root=insertNodeRecursive(root,75);
        root=insertNodeRecursive(root,80);
        root=insertNodeRecursive(root,85);
        BTInOrder.inOrderRecursive(root);
        System.out.println();
        //System.out.println(searchBSTRecursive(root,72));
      //  System.out.println(searchBST(root,60));
       // root=deleteRecursive(root,20);
        root=delete(root,30);
        BTInOrder.inOrderRecursive(root);
    }

    public static TreeNode delete(TreeNode root,int data){
        if(root==null) return null;
        TreeNode temp=root;
        TreeNode parent=null;
        Boolean left=false;
        Boolean right=false;
        while(temp!=null){
            if(temp.data==data){
                break;
            }
            parent=temp;
            if(temp.data>data){
                temp=temp.left;
                left=true;
                right=false;
            }else if(temp.data<data){
                temp=temp.right;
                left=false;
                right=true;
            }

        }
        if(temp.left==null || temp.right==null){
            temp=temp.left!=null?temp.left:temp.right;
            if(left){
                parent.left=temp;
            }else{
                parent.right=temp;
            }
        }else{
            TreeNode sucessor=getInOrderSucessor(temp);
            //TreeNode sucessorParent=getInOrderSucessorParent(root);
            TreeNode current=null;
            if(temp.data==root.data){
                current=root;
                root=sucessor;
            }else{

                if(left){
                    current=parent;

                    parent.left=sucessor;
                }else{
                    current=parent;
                    parent.right=sucessor;

                }
            }
            sucessor.left=current.left;

            // root.data=sucessor.data;
            //sucessor.right=null;

        }
        return root;
    }

    public static TreeNode deleteRecursive(TreeNode root,int data){
        if(root==null) return null;
        if(root.data>data){
            root.left=deleteRecursive(root.left,data);
        }else if(root.data<data){
            root.right=deleteRecursive(root.right,data);
        }else{
            TreeNode temp=null;
            if(root.left==null || root.right==null){
                temp=root.left!=null?root.left:root.right;
                return temp;
            }else{
                TreeNode sucessor=getInOrderSucessor(root);
                root.data=sucessor.data;
                root.right=deleteRecursive(root.right,sucessor.data);
            }
        }
        return root;
    }

    private static TreeNode getInOrderSucessor(TreeNode root) {
        TreeNode temp=root.right;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }

    private static TreeNode getInOrderSucessorParent(TreeNode root) {
        TreeNode temp=root.right;
        TreeNode sucessorParent=root;
        while(temp.left!=null){
            root=temp;
            temp=temp.left;
        }
        return root;
    }

    private static boolean searchBST(TreeNode root,int data){
        if(root==null) return false;
        while(root!=null){
            if(root.data==data){
                return true;
            }
            if(root.data>data){
                root=root.left;
            }else{
                root=root.right;
            }
        }
       return false;

    }

    private static boolean searchBSTRecursive(TreeNode root,int data){
        if(root==null) return false;
        if(root.data==data) return true;
        if(root.data>data){
            return searchBSTRecursive(root.left,data);
        }else{
            return searchBSTRecursive(root.right,data);
        }

    }

    public static TreeNode insertNodeRecursive(TreeNode root, int data) {
        if(root==null){
            return new TreeNode(data);
        }
        if(root.data>data)
        {
            root.left=insertNodeRecursive(root.left,data);
        }else{
            root.right=insertNodeRecursive(root.right,data);
        }
        return root;

    }

    public static TreeNode insertNode(TreeNode root, int data) {
        TreeNode node=new TreeNode(data);
        if(root==null){
            return node;
        }
        TreeNode temp=root;
        TreeNode parent=null;
        while(temp !=null){
            parent=temp;
            if(temp.data>data){
                temp=temp.left;
            }else{
                temp=temp.right;
            }


        }
        if(parent.data>data){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return root;
    }

}
