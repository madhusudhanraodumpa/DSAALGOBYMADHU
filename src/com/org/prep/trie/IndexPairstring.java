package com.org.prep.trie;
import java.util.*;

public class IndexPairstring {
    /*public static void main(String args[]){
        IndexPairstring in=new IndexPairstring();
        String[] w={"story","fleet","leetcode"};
        in.indexPairs("thestoryofleetcodeandme",w);
    }
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new LinkedList<>();
        Node trie=new Node();
        for(String str:words){
            insert(str,trie);
        }

        for(int start=0;start<text.length();start++){
            int end=start;

            while(end<text.length()){
                int index=text.charAt(end)-'a';
                if(trie.childs[index]==null) break;



                trie=trie.childs[index];
                if(trie.isEnd){
                    result.add(new int[] { start, end });

                }
                end++;
            }

        }
        return result.toArray(new int[result.size()][2]);

    }

    public void insert(String str,Node trie){

        int n=str.length();
        for(int i=0;i<n;i++){
            int index=str.charAt(i)-'a';

            if(trie.childs[index]==null){
                Node t=new Node();
                trie.childs[index]=t;
                trie=t;
            }else{
                trie=trie.childs[index];
            }
        }
        trie.isEnd=true;

    }*//*
}
class Node{
    boolean isEnd;
    Node[] childs=new Node[26];
    Node(){
        isEnd=false;
    }
*/
}
