package com.org.learnby.bitmasking;

public class UniqueNumber {
    public static void main(String args[]){
        int a[]={2,3,4,6,2,7,6,7,4};
        System.out.println("Unique Number is = "+findUniqueNumber(a));
    }

    private static String findUniqueNumber(int[] a) {
        int ans=0;
        for(int i:a){
            ans = ans^i;
        }
        return ans+"";
    }
}
