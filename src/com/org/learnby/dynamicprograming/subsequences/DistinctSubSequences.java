package com.org.learnby.dynamicprograming.subsequences;

public class DistinctSubSequences {
    public static void main(String args[]){
        String t="rabbit";
        int count=0;
        String[] list=findSubsequences("rabbbit");

        for(String str:list){
            if(str.equals(t)){
                count++;
            }
        }
        System.out.println(countDistinceSubsequence("rabbbit","rabbit"));
    }

    public static String[] findSubsequences(String str){
        if(str.length()==0){
            String ans[]={""};
            return ans;
        }

        String smallAns[]=findSubsequences(str.substring(1));
        String ans[]=new String[2*smallAns.length];

        int k=0;
        for(int i=0;i<smallAns.length;i++){
            ans[k]=smallAns[i];
            k++;
        }
        for(int i=0;i<smallAns.length;i++){
            ans[k]=str.charAt(0)+smallAns[i];
            k++;
        }

        return ans;
    }
    //https://www.youtube.com/watch?v=NR9lLQnFjWc
    public static int countDistinceSubsequence(String s, String t){
        int m = s.length();//11
        int n = t.length();//3
        int[][] dp =new int[n+1][m+1];
        for(int i = 1;i<=m;i++){
            if(t.charAt(0) == s.charAt(i-1)){
                dp[1][i] = dp[1][i-1]+1;

            }else{
                dp[1][i] = dp[1][i-1];
            }
        }

        for(int i=2 ;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] +dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

}
