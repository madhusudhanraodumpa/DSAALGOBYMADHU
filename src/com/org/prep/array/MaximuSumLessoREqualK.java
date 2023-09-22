package com.org.prep.array;
import java.util.*;

public class MaximuSumLessoREqualK {
        public static void main(String args[]){
            int[] a={1,2,3,4,5};



      //      System.out.println(maxSubarray(3,0,a));

            System.out.println(findMaxSubarraySum(a,5,11));
        }



    static int findMax(int a, int b){
        if(a>b)
            return a;
        return b;
    }
   static int maxSumsubarray(int arr[], int n, int maxSum){
        int sum = arr[0], overallMax = 0, start = 0;
        for (int i = 1; i < n; i++) {
            if (sum <= maxSum)
                overallMax = findMax(overallMax, sum);
            while (sum + arr[i] > maxSum && start < i) {
                sum -= arr[start];
                start++;
            }
            sum += arr[i];
        }
        if (sum <= maxSum)
            overallMax = findMax(overallMax, sum);
        return overallMax;
    }

        public static int maxSubarray(int A, int B, int[] C) {
            Arrays.sort(C);

            int n= C.length;
            int maxSum=Integer.MIN_VALUE;
            int start=0;
            int sum=0;
            for(int i=0;i<n;i++){

                sum=sum+C[i];
                if(sum<=B){
                    maxSum=Math.max(maxSum,sum);
                }
                while(sum>B && start<i){
                    sum=sum-C[start];
                    start++;

                }

                if(sum<=B){
                    maxSum=Math.max(maxSum,sum);
                }
            }


            return maxSum;


        }

    static int findMaxSubarraySum(int arr[], int n, int k) {
        int right = 0;
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            right += arr[i];
            // right - left <= k -> left >= right - k
            Integer left = bst.ceiling(right - k);
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        if (ans == Integer.MIN_VALUE) return 0; // not found!
        return ans;
    }
}
