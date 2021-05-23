package com.org.learnby.dynamicprograming.palindrome;

public class PalindromicStrings {
    int count1=0;
    public static void main(String args[]){
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1] || j-i==1){
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countSubstringsOpt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return count1;
    }

    private void findPalindrome(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            count1++;
            l--;
            r++;
        }
    }
}
