package com.org.prep.binarysearch;

public class PaintersPartitionProblem {
    public static void main(String args[]){
        int a[]={658, 786, 531, 47, 169, 397, 914};
        System.out.println(paint(5,10,a));
    }




    public static int paint(int A, int B, int[] C) {
        int n=C.length;
        int l=Integer.MIN_VALUE;
        int h=0;
        for(int i=0;i<n;i++){

            l=Math.max(l,C[i]);
            h=h+C[i];
        }
        if(n<=A){
            return (l*B)%10000003;
        }

        long ans=-1;
        while(l<=h){
            int m=(l+h)/2;

            if(checkPainterWilldo(C,n,m,A)){
                ans=m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return (int)((ans*B)%10000003);
    }

    public static boolean checkPainterWilldo(int C[],int n,int len,int painters){

            int c=0;
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+C[i];
                if(sum>len){
                    c++;
                    sum=C[i];
                }

            }

            if(sum>0){
                c++;
            }
            if(c<=painters){
                return true;
            }
            return false;
    }
}
