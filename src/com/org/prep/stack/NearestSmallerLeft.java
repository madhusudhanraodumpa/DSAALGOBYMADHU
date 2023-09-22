package com.org.prep.stack;
import java.util.*;

public class NearestSmallerLeft {
    public static void main(String args[]){
        int a[]={1};
        prevSmaller(a);
    }

    public static int[] prevSmaller(int[] a) {
        Stack<Integer> st=new Stack<>();

        int n=a.length;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[i]<=st.peek()){
                st.pop();
            }

            if(!st.isEmpty() && a[i]>st.peek()){
                ans[i]=st.peek();
            }
            else{
                ans[i]=-1;
            }

            st.push(a[i]);




        }

        return ans;
    }
}
