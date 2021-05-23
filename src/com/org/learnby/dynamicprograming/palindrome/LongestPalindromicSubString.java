package com.org.learnby.dynamicprograming.palindrome;

public class LongestPalindromicSubString {
    public static void main(String args[]){
        System.out.println(longestPalindrome("abaabd"));
        System.out.println(palStringWithConstantSpace("abaabd"));
    }
    public static int longestPalindromeLength(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxLen=Integer.MIN_VALUE;

        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        maxLen=Math.max(maxLen,j-i+1);
                    }
                }
            }
        }
        return maxLen;
    }

    public static String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        if(s.length()==1) return s;

        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        String subString="";

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxLen=Integer.MIN_VALUE;

       /* for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1] || j-i==1){
                        dp[i][j]=true;
                        if(maxLen<j-i+1 ){
                            subString=s.substring(i,j+1);
                            maxLen=j-i+1;
                        }
                    }
                }
            }
        }*/

        for(int len=2; len<=n;len++){

            for(int i=0;i<n-len+1;i++){
                int j = i+len-1;
                if(s.charAt(i) ==  s.charAt(j)){
                    if(dp[i+1][j-1] || len ==2){
                        dp[i][j] = true;
                        if(maxLen<j-i+1){
                            maxLen = j- i+1;
                            subString = s.substring(i,j+1);

                        }
                    }
                }
            }
        }
        return subString.length()==0?s.substring(0,1):subString;
    }
     public static String longestPalndromicSubstringBruteForce(String s){

        int n = s.length();
        int maxLen= Integer.MIN_VALUE;
        String palString= "";

        for(int i=0;i<n;i++){

            for(int j=i;j<n;j++){
                if(isPalindrom(s.substring(i,j+1))){
                    if(maxLen<s.substring(i,j+1).length()){
                        maxLen = s.substring(i,j+1).length();
                        palString = s.substring(i,j+1);
                    }

                }

            }

        }
        return palString;

     }

    private static boolean isPalindrom(String s) {
        int n = s.length();
        int j= n-1;
        for(int i=0;i<n;i++){
            if(i>j){
                break;
            }
            if(s.charAt(i) == s.charAt(j)){
                j--;
            }else{
                return false;
            }
        }
        return true;

    }


    public static String palStringWithConstantSpace(String s){
        int n= s.length();
        if( n==0 || n==1) return s;
        int max_len = 1;
        String result= s.charAt(0)+"";
        int left =0;
        int right = 0;
        for(int i =1; i<n;i++){
            left = i-1;
            right = i;

            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                    if(right -left+1>max_len){
                        max_len = right-left+1;
                        result = s.substring(left,right+1);
                    }
                left = left -1;
                right = right+1;

            }
            left = i-1;
            right = i+1;

            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                if(right -left+1>max_len){
                    max_len = right-left+1;
                    result = s.substring(left,right+1);
                }
                left = left -1;
                right = right+1;

            }

        }

        return result;
    }
}
