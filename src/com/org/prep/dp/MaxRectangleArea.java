package com.org.prep.dp;

import java.util.Stack;

public class MaxRectangleArea {
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 0}};
        MaxRectangleArea m = new MaxRectangleArea();
        System.out.println(m.maximalRectangle(A));

    }
    public int maximalRectangle(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        for(int i=0;i<m;i++) {
            int sum=0;
            for(int j=0;j<n;j++) {
                if(A[j][i]==0){
                    sum=0;
                }else{
                    sum=sum+1;
                }
                A[j][i]=sum;
            }
        }

        int maxRectangleArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {

            maxRectangleArea = Math.max(maxRectangleArea,largestRectangleArea(A[i]));
        }

        return maxRectangleArea;

    }



    public int largestRectangleArea(int[] A) {

        int n=A.length;
        int[] p1=prevSmaller(A);
        int[] p2=nextSmaller(A);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,(p2[i]-p1[i]-1)*A[i]);
        }
        return maxArea;
    }


    public int[] prevSmaller(int[] a) {
        Stack<Integer> st=new Stack<>();

        int n=a.length;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (a[i]<=a[st.peek()])){
                st.pop();
            }

            if(!st.isEmpty() && a[i]>a[st.peek()]){
                ans[i]=st.peek();
            }
            else{
                ans[i]=-1;
            }

            st.push(i);




        }

        return ans;
    }

    public int[] nextSmaller(int[] a) {
        Stack<Integer> st=new Stack<>();

        int n=a.length;
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (a[i]<=a[st.peek()])){
                st.pop();
            }

            if(!st.isEmpty() && a[i]>a[st.peek()]){
                ans[i]=st.peek();
            }
            else{
                ans[i]=n;
            }

            st.push(i);




        }

        return ans;
    }
}
