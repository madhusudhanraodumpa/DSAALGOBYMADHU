package com.org.learnby.recursion;

public class TillingProblem {
    public static void main(String args[]){
        System.out.println(tilesPlaceHowManyWays(7));
    }

    private static int tilesPlaceHowManyWays(int n) {
        if(n<=3){
            return 1;
        }
        return tilesPlaceHowManyWays(n-1)+tilesPlaceHowManyWays(n-4);

    }
}
