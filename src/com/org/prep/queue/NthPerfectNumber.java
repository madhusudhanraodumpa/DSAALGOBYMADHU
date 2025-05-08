package com.org.prep.queue;
import java.util.*;

public class NthPerfectNumber {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    public static String solve(int A) {

        Queue<String> q=new LinkedList<>();
        q.offer("11");
        if(A==1) return q.peek();
        q.offer("22");
        if(A==2) return q.peek();
        int c=2;
        while(c<A){
            String val=q.peek();
            q.poll();
            int n = val.length()/2;
            String ans=val.substring(0,n)+"11"+val.substring(n,val.length());
            c++;
            q.offer(ans);if(A==c) return ans;

            ans=val.substring(0,n)+"22"+val.substring(n,val.length());
            c++;
            q.offer(ans);if(A==c) return ans;
        }
        return null;


    }
}
