package com.org.prep.queue;
import java.util.*;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int a[]={10,9,8,7,6,5,4,3,2,1};
        slidingMaximum(a,2);
    }
    public static int[] slidingMaximum(final int[] A, int B) {
        int n=A.length;
        Deque<Integer> q=new LinkedList<>();
        int[] ans=new int[n-B+1];
        int c=0;
        for(int i=0;i<B;i++){
            while(!q.isEmpty() && q.peekLast()<A[i]){
                q.pollLast();
            }
            q.offerLast(A[i]);

        }
        ans[c++]=q.peekFirst();

        int l=1;
        int r=B;
        while(r<n){
            if(!q.isEmpty() && q.peekFirst()==A[l-1]){
                q.pollFirst();
            }
            while(!q.isEmpty() && q.peekLast()<A[r]){
                q.pollLast();
            }
            q.offerLast(A[r]);

            ans[c++]=q.peekFirst();
            l++;
            r++;
        }



        return ans;

    }
}
