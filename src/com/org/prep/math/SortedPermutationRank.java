package com.org.prep.math;

public class SortedPermutationRank {

    public static void main(String args[]){
        System.out.println(findRank("baa"));
    }

    public static int findRank(String A) {
        // A=A.toLowerCase();
        int n=A.length();
        int[] alpha=new int[256];
        int mod=1000003;

        for(int i=0;i<n;i++){
            alpha[A.charAt(i)]++;
        }
        int[] fact=new int[26];
        fact[0]=1;
        fact[1]=1;
        for(int i=2;i<26;i++){
            fact[i]=(fact[i-1]%mod*i%mod)%mod;
        }


        int rank=0;

        for(int i=0;i<n;i++){
            int count=0;
            char charVal=A.charAt(i);
            for(int j=0;j<(int)charVal;j++){
                if(alpha[j]!=0){
                    count=count+alpha[j]    ;
                }
            }
            alpha[charVal]=alpha[charVal]-1;

            rank=(rank+(count*fact[n-1-i]%mod)%mod)%mod;

        }
        return (rank+1)%1000003;

    }
}
