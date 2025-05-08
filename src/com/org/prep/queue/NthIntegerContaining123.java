package com.org.prep.queue;

public class NthIntegerContaining123 {
    public static void main(String[] args) {
        System.out.println(solve(7));
    }
    public static int[] solve(int A) {
        int ans[]=new int[A];
        ans[0]=1;
        if(A==1) return ans;
        ans[1]=2;
        if(A==2) return ans;
        ans[2]=3;
        if(A==3) return ans;

        int c=3;
        int i=0;
        while(c<A){
            int val=ans[i];
            ans[c++]=val*10+1;
            if(c==A) return ans;
            ans[c++]=val*10+2;
            if(c==A) return ans;
            ans[c++]=val*10+3;
            if(c==A) return ans;
            i++;

        }
        return ans;


    }
}
