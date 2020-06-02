package com.org.learnby.recursion;

public class LadderProblem {
    public static void main(String args[]){
        System.out.println(howMAnyWayToReachTop(4,3));
    }

    private static int howMAnyWayToReachTop(int n,int k) {
       if(n==0){
           return 1;
       }
       if(n<0){
           return 0;
       }
       int ans=0;
       for(int i=1;i<=k;i++){
           ans+=howMAnyWayToReachTop(n-i,k);
       }
        return ans;
    }
}
