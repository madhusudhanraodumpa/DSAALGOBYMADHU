package com.org.learnby.recursion;

public class FriendsPairingProblem {
    public static void main(String args[]){
        System.out.println(friendsPair(3));
    }

    private static int friendsPair(int n) {
        if(n==1 || n==2 ){
            return n;
        }
        if(n==0){
            return 1;
        }
        return friendsPair(n-1)+((n-1)*friendsPair(n-2));

    }
}
