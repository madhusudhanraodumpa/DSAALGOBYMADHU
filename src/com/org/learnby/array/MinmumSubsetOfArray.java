package com.org.learnby.array;

public class MinmumSubsetOfArray {

    public static void main(String args[]) {
        int[] a =   {1, 4, 45, 6, 0, 19,52};

        int f = 0, r = 0;
        int sum = 51;
        int currentsum = 0;
        int minSubset = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            currentsum = a[i] + currentsum;
            r++;
            if (currentsum < sum) {
                if(currentsum<=0 && sum>0){
                    f=r;
                    currentsum=0;
                }
                continue;
            } else {
                if (minSubset > (r - f)) {
                    minSubset = r - f;
                }
                while (currentsum - a[f] > sum) {
                    currentsum = currentsum - a[f++];
                    if (minSubset > (r - f)) {
                        minSubset = r - f;
                    }
                }
            }
        }
        if(minSubset>a.length){
            System.out.println("Not possible");
        }
        System.out.println(minSubset);
    }
}
