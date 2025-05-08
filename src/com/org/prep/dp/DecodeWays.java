package com.org.prep.dp;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String rags[]){
        DecodeWays d=new DecodeWays();
        int[] dp =new int[5];
        Arrays.fill(dp,-1);
      // System.out.println(d.decodeR("1111",4,dp));
        System.out.println(d.numDecodings("1111"));

    }

    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        int mod=1000000007;
        for (int i=2;i<=n;i++) {
            int firstDigit=Integer.parseInt(s.substring(i-1,i));
            if(firstDigit>=0 && firstDigit<=9) {
                dp[i]=dp[i-1];
            }
            int secondDigit=Integer.parseInt(s.substring(i-2,i-1));
            if(secondDigit==1){
                dp[i]=(dp[i]%mod+dp[i-2]%mod)%mod;
            } else if (secondDigit==2 && firstDigit>=0 && firstDigit<=6) {
                dp[i] = (dp[i]%mod+dp[i-2]%mod)%mod;
            }
        }
        return dp[n]%mod;
    }


//    public int decodeR(String s,int n,int[] dp) {
//        if(n==0 ) {
//            dp[0] = 1;
//            return dp[0];
//        }
//        if(n==1) {
//            dp[n]=1;
//            return dp[n];
//        }
//
//        if(dp[n]==-1){
//
//
//            int firstDigit=Integer.parseInt(s.substring(n-2,n-1));
//            int secondDigit=Integer.parseInt(s.substring(n-1,n));
//            if(secondDigit>=1 && secondDigit<=9) {
//                dp[n]=decodeR(s,n-1,dp);
//            }
//            if(firstDigit==1){
//                dp[n]=dp[n]+decodeR(s,n-1,dp);
//            }
//            else if(firstDigit==2 && secondDigit>=0 && secondDigit<=6) {
//                dp[n]=dp[n]+decodeR(s,n-2,dp);
//            }
//        }
//
//
//
//        return dp[n];
//    }

//    public int decode(String s,int n){
//
//        int[] dp=new int[n];
//
//        if(n==0 || s.charAt(0)=='0') return 0;
//        dp[0]=1;
//        for(int i=1;i<n;i++){
//            int firstDigit=Integer.parseInt(s.substring(i,i+1));
//            int secondDigit=Integer.parseInt(s.substring(i-1,i+1));
//            if(secondDigit>=10 && secondDigit<=26){
//                dp[i] = dp[i]+i>=2?dp[i-2]:1;
//            }
//            if(firstDigit>=1){
//                dp[i]=dp[i]+dp[i-1];
//            }
//
//        }
//        return dp[n-1];
//    }

     public int decode(String s,int i,int[] dp){

          if(i>=s.length()) {
              dp[i]=1;
              return dp[i];
          }
          if(s.charAt(i)=='0') return 0;
          if(i==s.length()-1) {
              dp[i]=1;
              return dp[i];
          }


          int firstDigit=Integer.parseInt(s.substring(i,i+1));
          int secondDigit=Integer.parseInt(s.substring(i,i+2));
         if(dp[i]==-1) {
             int ans = 0;
            if (firstDigit >= 1) {
                ans =  ans+ decode(s, i + 1,dp);

            }
            if (secondDigit >= 10 && secondDigit <= 26) {
                ans =  ans+ decode(s, i + 2,dp);
            }
            dp[i]=ans;
        }
          return dp[0];


      }

//      public int decode1(String s){
//          int n=s.length();
//          /**  if(n==1 && s.charAt(0)=='0'){
//           return 0;
//           }**/
//    /**    int[] dp=new int[n+1];
//        dp[0]=1;
//        if(s.charAt(0)=='0'){
//            dp[1]=0;
//        }else{
//            dp[1]=1;
//        }
//
//
//        for(int i=2;i<n;i++){
//            int firstDigit=Integer.parseInt(s.substring(i-1,i));
//            int secondDigit=Integer.parseInt(s.substring(i-2,i));
//
//            if(firstDigit>=1){
//                dp[i]=dp[i]+dp[i-1];
//            }
//            if(secondDigit>=10 && secondDigit<=26){
//                dp[i]=dp[i]+dp[i-2];
//            }
//
//
//        }
//        return dp[n];
//
//
//    }**/
}
