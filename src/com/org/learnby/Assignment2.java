package com.org.learnby;

public class Assignment2 {
    public static void main(String args[]){
        int a[]={1,9,8,7,5,3,10};
        int b[]={1,2,5,0,7,0,10,0,9};
        int c[]={-2,-3,4,-1,-2,1,5,-3};
        findFirstSecondThirdLargest(a);
        findMaxSum(c);
        moveAllZerosEnd(b);
    }

    private static void findMaxSum(int[] c) {
    }

    private static void moveAllZerosEnd(int[] b) {
        int countSwap=0;
        for(int i=0;i<b.length-1;i++){
            if(b[i]!=0 && countSwap<=0){

            }else if(countSwap>0){
                while(countSwap>0) {
                    b[i] = b[i + 1];
                    countSwap--;
                }
            }else{
                countSwap++;
            }
        }
        for(int j=0;j<b.length;j++){
            System.out.print(" "+b[j]);
        }
        System.out.println();
    }
    private static void moveAllZerosEnd1(int[] b) {
        int count=0;
        for(int i=0;i<b.length;i++){
            if(b[i]!=0){
                b[count++]=b[i];
            }
        }
        while (count<b.length){
            b[count++]=0;
        }
        for(int j=0;j<b.length;j++){
            System.out.print(" "+b[j]);
        }
        System.out.println();
    }
    private static void findFirstSecondThirdLargest(int[] a) {
        int f=a[0];
        int s=a[0];
        int t=a[0];
        for(int i=1;i<a.length;i++){
            if(f<a[i]){
                t=s;
                s=f;
                f=a[i];
            }else if(s<a[i]){
                t=s;
                s=a[i];
            }else if(t<a[i]){
                t=a[i];
            }
        }
        System.out.println(" "+f+" "+s+" "+t);
    }
}
