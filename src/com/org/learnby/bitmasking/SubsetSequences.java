package com.org.learnby.bitmasking;

public class SubsetSequences {
    public static void main(String args[]){
    printSubsets("abc".toCharArray());
    }
    static void filterChar(int n,char a[]){
        int j=0;
        while(n>0){
            if((n &1)==1){
                System.out.print(a[j]);
            }
            j++;
            n =n>>1;
        }
        System.out.println();
    }
    public static void printSubsets(char a[]){
        int n=a.length;
        for(int i=0;i<(1<<n);i++){
            filterChar(i,a);
        }
    }
}
