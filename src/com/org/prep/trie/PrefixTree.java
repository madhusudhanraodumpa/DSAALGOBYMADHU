package com.org.prep.trie;

public class PrefixTree {
   /* public static void main(String args[]){
        PrefixTree p=new PrefixTree();
        p.insert("apple");
        p.search("apple");
        p.search("app");
        p.startsWith("app");
    }

    Node root;
    public PrefixTree() {
        root= new Node();
    }
    public Node getTrie(){
        return root;
    }

    public void insert(String word) {
        Node trie=getTrie();

        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(trie.childs[index]==null){
                Node t=new Node();
                trie.childs[index]=t;
                trie=t;
            }else{
                trie=trie.childs[index];
            }
        }
        trie.isEnd=true;

    }

    public boolean search(String word) {
        Node trie=getTrie();

        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(trie.childs[index]==null) return false;
            trie=trie.childs[index];

        }
        return trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node trie=getTrie();

        int n=prefix.length();
        for(int i=0;i<n;i++){
            int index=prefix.charAt(i)-'a';
            if(trie.childs[index]==null) return false;
            trie=trie.childs[index];

        }
        return true;
    }
}

class Node{
    Node[] childs=new Node[26];
    boolean isEnd;
    Node(){
        isEnd=false;
    }*/
}