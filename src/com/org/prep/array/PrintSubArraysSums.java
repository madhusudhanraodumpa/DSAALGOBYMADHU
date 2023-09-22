package com.org.prep.array;

public class PrintSubArraysSums {
    //brute force approch
    public static void main(String[] args) {
        int[] a={8,2,9};
        int n=a.length;
        for(int s=0;s<n;s++){
            for(int e=s;e<n;e++){
                int sum =0;
                for(int k=s;k<=e;k++){
                    sum=sum+a[k];
                }
                System.out.println(sum);
            }

        }
        System.out.println();
        printSubarraysSum(a);
        printSubarraysSum1(a);
    }

    //prefix sum approch
    private static void printSubarraysSum(int[] a) {
        System.out.println("starting");
        int n=a.length;
        int pf[]=new int[n];

        pf[0]=a[0];
        for(int i=1;i<n;i++){
            pf[i]=pf[i-1]+a[i];
        }
        for(int s=0;s<n;s++){
            for(int e=s;e<n;e++) {
                if(s==0){
                    System.out.println(pf[e]);
                }else{
                    System.out.println(pf[e]-pf[s-1]);
                }


            }
            }
    }

    private static void printSubarraysSum1(int[] a) {
        System.out.println("starting");
        int n=a.length;
        for(int s=0;s<n;s++){
            int sum=0;
            for(int e=s;e<n;e++) {
                sum=sum+a[e];
                System.out.println(sum);
            }
        }
    }

}
