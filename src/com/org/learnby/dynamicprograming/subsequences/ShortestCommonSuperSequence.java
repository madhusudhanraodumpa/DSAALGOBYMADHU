package com.org.learnby.dynamicprograming.subsequences;

public class ShortestCommonSuperSequence {
        public static void main(String args[]){
            System.out.println(shortestCommonSupersequence("abac","cab"));
        }


    public static String shortestCommonSupersequence(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        int[][] t=new int[m+1][n+1];


        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }


            }
        }

        int i=m;
        int j=n;
        String s="";
        StringBuilder buffer = new StringBuilder();
        while(i>0 && j>0){

            if(s1.charAt(i-1)==s2.charAt(j-1)){

                s=s1.charAt(i-1)+s;
                i--;
                j--;
            }else if(t[i-1][j]<t[i][j-1]){
                s=s2.charAt(j-1)+s;
                j--;
            }else{
                s=s1.charAt(i-1)+s;
                i--;
            }



        }
        while(i>0){
            s=s1.charAt(i-1)+s;
            i--;
        }
        while(j>0){
            s=s2.charAt(j-1)+s;
            j--;
        }

        return s;
    }
}
