package com.org.prep.stack;
import java.util.*;

public class LargetRectangleHistrogram {
    public static void main(String args[]){
       // int a[]={90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        int A[][]={{1,1,0,1,0,1},{0,1,1,1,1,1},{1,1,1,1,1,0},{1,0,1,0,0,1},{1,1,0,0,1,1}};
        int n=A.length;
        int m=A[0].length;

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]==0){
                    A[i][j]=0;
                }else{
                    A[i][j]=A[i-1][j]+A[i][j];
                }
            }
        }
        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            maxArea=Math.max(maxArea,largestRectangleArea(A[0]));

        }

        System.out.println(maxArea);

        //largestRectangleArea(a);

    }

    public static int largestRectangleArea(int[] A) {

        int n=A.length;
        int[] p1=prevSmaller(A);
        int[] p2=nextSmaller(A);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,(p2[i]-p1[i]-1)*A[i]);
        }
        return maxArea;
    }


    public static int[] prevSmaller(int[] a) {
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

    public static int[] nextSmaller(int[] a) {
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
