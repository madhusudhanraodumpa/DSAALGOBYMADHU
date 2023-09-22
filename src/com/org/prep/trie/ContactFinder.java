package com.org.prep.trie;
import java.util.*;

public class ContactFinder {
/*

    public static void main(String args[]){
        ContactFinder c=new ContactFinder();
        int[] A={0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        String[] B={"s", "ss", "sss", "ssss", "sssss", "s", "ss", "sss", "ssss", "sssss", "ssssss"};
        c.solve(A,B);
    }

    //public int[] solve(int[] A, String[] B) {
       */
/* Node trie=new Node();
        List<Integer> list = new ArrayList<>();
        int n=A.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(A[i]==0){
                insert(B[i],trie);
            }else{
                list.add(search(B[i],trie));
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int search(String s,Node trie){

        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(!trie.map.containsKey(ch)){
                return 0;
            }else{
                trie=trie.map.get(ch);
            }
        }
        return trie.isEnd;
    }

    public void insert(String s,Node trie){

        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(!trie.map.containsKey(ch)){
                Node t=new Node();
                trie.map.put(ch,t);
                trie=t;
                trie.isEnd=1;

            }else{
                trie=trie.map.get(ch);
                trie.isEnd=trie.isEnd+1;

            }
        }
    }*//*



}
*/





}

