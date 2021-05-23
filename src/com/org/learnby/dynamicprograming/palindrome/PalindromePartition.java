package com.org.learnby.dynamicprograming.palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String args[]){
        String s="banana";
        //System.out.println(minCut(s,0,s.length()-1));
        System.out.println(minCutDP(s));
        System.out.println(minCutDPOpt(s));
        partition("radar");

    }
    public static int minCut(String s,int i,int j) {
        if(i>=j) return 0;


        int minCut=Integer.MAX_VALUE;

        if(isPalindrome(s,i,j)) return 0;

        for(int k=i;k<=j-1;k++) {
            int temp = minCut(s,i,k)+minCut(s,k+1,j)+1;
            minCut=Math.min(temp,minCut);
        }

        return minCut;

    }

    //O(n^3) complexity
    public static int minCutDP(String s) {
        int n=s.length();
        int dp[][] = new int[n][n];
        for(int l= 2; l <=n; l++){
            for(int i = 0; i <= n-l; i++){
                int j=l+i-1;
                if(isPalindrome(s,i,j)){
                    dp[i][j]=0;
                }else{
                    int r=0;
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<=j-1;k++){
                        r=dp[i][k]+dp[k+1][j]+1;
                        if(r<dp[i][j]){
                            dp[i][j]=r;
                        }
                    }
                }
            }
        }
      return dp[0][n-1];

    }

    //O(n^2) complexity
   // https://www.youtube.com/watch?v=WPr1jDh3bUQ
    public static int minCutDPOpt(String s) {


        int n=s.length();
        boolean dp[][]=new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1] || j-i==0){
                        dp[i][j]=true;
                    }
                }
            }
        }

        int[] cuts=new int[n];
        for(int i=0;i<n;i++){
            int temp = Integer.MAX_VALUE;
            if(isPalindrome(s,0,i)){ // instead checking each time palindromic logic we can get dp already calculated.
                                            // like dp[0][i]
                cuts[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    if(isPalindrome(s,j+1,i) && temp>cuts[j]+1){ // get palndromic value from dp is dp[j+1][i]
                        temp=cuts[j]+1;
                    }
                }
                cuts[i]=temp;
            }

        }
        return cuts[n-1];

    }

    private static boolean isPalindrome(String s, int start, int end) {

        while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end --;
            }else{
                return false;
            }
        }
        return true;
    }
//https://www.youtube.com/watch?v=HXPucS3X3NA
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findAll(s,result,new ArrayList<>());
         return result;

    }
    public static void findAll(String s,List<List<String>> result, List<String> temp){

        if(s.length() ==0){
            result.add(new ArrayList<>(temp));
        }

        for(int i =0;i<s.length();i++){
            String leftPar = s.substring(0,i+1);
            if(isPalindrome(leftPar,0,leftPar.length()-1)){
                temp.add(leftPar);
                findAll(s.substring(i+1),result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
