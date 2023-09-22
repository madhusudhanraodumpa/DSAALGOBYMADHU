package com.org.prep.trie;

public class LongestWordDictionary {
 /*   public static void main(String args[]){
        String[] a={"a","banana","app","appl","ap","apply","apple"};
        LongestWordDictionary l=new LongestWordDictionary();
        l.longestWord(a);
    }

    public String longestWord(String[] words) {
        int n=words.length;
        Node trie=new Node();
        String maxString="";
        for(int i=0;i<n;i++){
            insert(words[i],trie);
        }
        for(int i=0;i<n;i++){
            String r = search(words[i],trie);
            if(r.length()>maxString.length()){
                maxString=r;
            }else if(r.length()==maxString.length()){
                if(r.compareTo(maxString)<0){
                    maxString=r;
                }
            }
        }

        return maxString;
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

    }

    public String search(String str,Node trie){

        int n=str.length();
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<n;i++){
            int index=str.charAt(i)-'a';

            if(trie.childs[index]==null){
                return "";
            }else{

                trie=trie.childs[index];
                if(trie.isEnd){
                    stb.append(str.charAt(i));
                }else{
                    return "";
                }
            }
        }

        return stb.toString();

    }
}

class Node{
    boolean isEnd;
    Node[] childs=new Node[26];
    Node(){
        isEnd=false;
    }*/

}
