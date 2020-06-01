package com.org.learnby.bitmasking;

public class FindTwoIniqueNumbers {
    public static void main(String args[]){
        int a[]={2,1,3,2,5,1,5,7};
        findTwoUniqueNumbers(a);
    }

    private static void findTwoUniqueNumbers(int[] a) {
        int value=0;
        for(int n:a){
            value=value^n;
        }
        int temp=value;
        int pos=0;
        while( (temp & 1)!=1){
            pos++;
            temp=temp>>1;
        }

        int x=0;
        int y=0;
        int mask=1<<pos;
        for(int i=0;i<a.length;i++){
            if((a[i] & mask)>0){
                x=x^a[i];
            }

        }
        y=value^x;
        System.out.println(y);
        System.out.println(x);


    }
}
