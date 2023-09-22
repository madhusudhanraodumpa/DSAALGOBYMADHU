package com.org.prep.dp;

public class DecodeWays {
    public static void main(String rags[]){
        DecodeWays d=new DecodeWays();
       System.out.println(d.decode("12",2));
    }




    public int decode(String s,int n){

        int[] dp=new int[n];

        if(n==0 || s.charAt(0)=='0') return 0;
        dp[0]=1;
        for(int i=1;i<n;i++){
            int firstDigit=Integer.parseInt(s.substring(i,i+1));
            int secondDigit=Integer.parseInt(s.substring(i-1,i+1));
            if(secondDigit>=10 && secondDigit<=26){
                dp[i] = dp[i]+i>=2?dp[i-2]:1;
            }
            if(firstDigit>=1){
                dp[i]=dp[i]+dp[i-1];
            }

        }
        return dp[n-1];
    }

    /**  public int decode(String s,int i){

          if(i>=s.length()) return 1;
          if(s.charAt(i)=='0') return 0;
          if(i==s.length()-1) return 1;


          int firstDigit=Integer.parseInt(s.substring(i,i+1));
          int secondDigit=Integer.parseInt(s.substring(i,i+2));

          int ans=0;
          if(firstDigit>=1){
              ans=ans+decode(s,i+1);

          }
          if(secondDigit>=10 && secondDigit<=26){
              ans=ans+decode(s,i+2);
          }
          return ans;


      }

      public int decode1(String s){
          int n=s.length();
          /**  if(n==1 && s.charAt(0)=='0'){
           return 0;
           }**/
    /**    int[] dp=new int[n+1];
        dp[0]=1;
        if(s.charAt(0)=='0'){
            dp[1]=0;
        }else{
            dp[1]=1;
        }


        for(int i=2;i<n;i++){
            int firstDigit=Integer.parseInt(s.substring(i-1,i));
            int secondDigit=Integer.parseInt(s.substring(i-2,i));

            if(firstDigit>=1){
                dp[i]=dp[i]+dp[i-1];
            }
            if(secondDigit>=10 && secondDigit<=26){
                dp[i]=dp[i]+dp[i-2];
            }


        }
        return dp[n];


    }**/
}
