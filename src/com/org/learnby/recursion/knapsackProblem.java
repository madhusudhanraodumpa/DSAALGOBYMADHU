package com.org.learnby.recursion;

public class knapsackProblem {
    public static void main(String args[]){
        int[] wt={1,2,3,5};
        int[] prices={40,20,30,100};
        int capacity=5;
        int size=4;
        System.out.println(profit(wt,prices,capacity,size));

    }

    private static int profit(int[] wt, int[] prices, int capacity, int size) {
        if(capacity == 0 || size == 0){
            return 0;
        }
        int inc=Integer.MIN_VALUE;
        int exc=Integer.MIN_VALUE;
        if(capacity >= wt[size-1]) {
            inc = prices[size - 1] + profit(wt, prices, capacity - wt[size - 1], size - 1);
        }
        exc=profit(wt,prices,capacity,size-1);
        int ans = Integer.max(inc,exc);
        return ans;
    }
}
