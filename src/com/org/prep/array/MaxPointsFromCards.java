package com.org.prep.array;

public class MaxPointsFromCards {
    public static void main(String args[]){
        int a[]={1,79,80,1,1,1,200,1};
        maxScore(a,3);
    }


    public static int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int max_points=Integer.MIN_VALUE;
        int points=0;

        int i=0;
        while(i<k){
            points=points+cardPoints[i];
            i++;
        }
        max_points=points;

        if(n==k)return max_points;
        i=k-1;
        int j=n-1;
        while(i>0){
            points=points-cardPoints[i];
            points=points+cardPoints[j];
            max_points=Math.max(points,max_points);
            i--;
            j--;

        }
        return max_points;
    }
}
