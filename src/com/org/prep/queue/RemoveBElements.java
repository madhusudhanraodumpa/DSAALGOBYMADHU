package com.org.prep.queue;

import java.util.*;

public class RemoveBElements {
    public static void main(String[] args) {
        int[] a={43,35,25,5,34,5,8,7};
        solve(a,6);

    }
    public  static int[] solve(int[] A, int B) {
        int n=A.length;
        Queue< Integer > q = new LinkedList < Integer > ();
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for( i=0;i<n;i++){
            q.offer(A[i]);
        }
        for( i=0;i<B;i++){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
        int k=n-B;
        while(k>0){
            q.offer(q.poll());
            k--;
        }
        i=0;

        while(q.size()>0){

            A[i++]=q.poll();
        }

        return A;

    }
}
