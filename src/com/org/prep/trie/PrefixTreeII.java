package com.org.prep.trie;

public class PrefixTreeII {
    public static void main(String args[]){
        PrefixTreeII p2=new PrefixTreeII();
        p2.insert("apple");
        p2.insert("apple");
        p2.countWordsEqualTo("apple");
    }
    Node root;
    public PrefixTreeII() {
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
                trie.count++;
            }else{

                trie=trie.childs[index];
                trie.count++;
            }
        }
        trie.isEnd=true;
    }

    public int countWordsEqualTo(String word) {
        Node trie=getTrie();
        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(trie.childs[index]==null){
                return 0;

            }else{

                trie=trie.childs[index];
            }
        }
        return trie.count;
    }

    public int countWordsStartingWith(String word) {
        Node trie=getTrie();
        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(trie.childs[index]==null){
                return 0;

            }else{

                trie=trie.childs[index];
            }
        }
        return trie.count;
    }

    public void erase(String word) {
        Node trie=getTrie();
        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';

            if(trie.childs[index]!=null){
                trie=trie.childs[index];
                trie.count--;
                if(trie.count==0){
                    trie.childs[index]=null;
                }
            }else{
                return;
            }
        }
    }

}
class Node{
    Node[] childs=new Node[26];
    boolean isEnd;
    int count;
    Node(){
        isEnd=false;
        count=0;
    }
}
