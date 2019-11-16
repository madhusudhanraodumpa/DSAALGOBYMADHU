package com.org.learnby.hash;

public class ContiguousSubarray {
    public static void main(String args[]){
        int a[]={-1,2,-4,6,-3,4,8,-1,-7,4,1,-2};
        int maxSum=0,max=0;
        int start=0,end=0,temp=0;
        for(int i=0;i<a.length;i++){
            maxSum+=a[i];
            if(maxSum<0){
                maxSum=0;
                temp=i+1;

            }
            if(maxSum>max){
                start=temp;
                end=i;
                max=maxSum;
            }
        }
        System.out.println(max);
        System.out.println(start);
        System.out.println(end);
    }
}
