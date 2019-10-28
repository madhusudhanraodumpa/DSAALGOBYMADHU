package com.org.learnby;

public class Assignment1 {
    public static void main(String[] args) {
        int a[]={1,2,3,4,6,7,8,9,10};
        int b[]={1,2,3,4,5,6,7,7,8,9,10};
        int c[]={1,2,3,4,5,6,7};
        int d[]={1,1,2,3,1,2,3};
        findMissingNumber(a);
        findOneDuplicateNumber(b);
        oneLeftRotation(c);
        findTriplicateNumber(d);
    }

    private static void findTriplicateNumber(int[] d) {
         int t=0;
         for(int i=0;i<d.length;i++){
             t=t^d[i];
         }
         System.out.println("Triplicate Number is = "+t);

    }

    public static void oneLeftRotation(int[] c){
        int temp=c[0];
        for(int i=0;i<c.length-1;i++){
            c[i]=c[i+1];
        }
        c[c.length-1]=temp;
        System.out.print("Rotated array is = ");
        for(int j=0;j<c.length;j++){
            System.out.print(" "+c[j]);
        }
        System.out.println();
    }

    private static void findOneDuplicateNumber(int[] b) {
        int n=b.length-1;
        int sumOfNumbers=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<b.length;i++){
            sum=sum+b[i];
        }
        System.out.println("Duplicate number is = "+ (sum-sumOfNumbers));
    }

    public static void findMissingNumber(int a[]){

        int n=a.length+1;
        int sumOfNumbers=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i]
;        }
        System.out.println("Missing number is = "+(sumOfNumbers-sum));
    }
}
