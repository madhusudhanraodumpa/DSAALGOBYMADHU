package com.org.prep.string;

public class PatternMatching {
    public static void main(String args[]){
        String A="ebbp";
        String B="qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc";

        solve(A,B);

    }

    public static int solve(String A, String B) {
        int m=A.length();
        String C=A+"$"+B;
        int[] lps=lps(C,C.length());

        int count=0;
        for(int i=0;i<lps.length;i++){
            if(lps[i]==m) count++;
        }

        return count;

    }


    public static int[] lps(String s,int n){
        int[] lps=new int[n];
        lps[0]=0;

        for(int i=1;i<n;i++){

            int x=lps[i-1];

            while(s.charAt(i)!=s.charAt(x)){

                if(x==0) {
                    x=-1;
                    break;
                }

                x=lps[x-1];

            }
            lps[i]=x+1;

        }
        return lps;



    }
}
