package com.org.prep.array;

import java.util.*;

public class MaximunSumSubbary {

    public static void main(String[] args) {
        int arr[] = { 5, -2, 6, 3, -5 };

        // Initialise the value of K
        int K = 15;

        // Size of array
        int N = arr.length;

        System.out.println(maxSubarraySum(arr, N, K));
    }


    static int maxSubarraySum(int arr[], int N,
                              int K)
    {

        // Hash to lookup for value (cum_sum - K)
        Set<Integer> cum_set = new HashSet<>();
        cum_set.add(0);

        int max_sum =Integer.MIN_VALUE, cSum = 0;

        for(int i = 0; i < N; i++)
        {

            // Getting cumulative sum from [0 to i]
            cSum += arr[i];

            // Lookup for upperbound
            // of (cSum-K) in hash
            ArrayList<Integer> al = new ArrayList<>();
            Iterator<Integer> it = cum_set.iterator();
            int end = 0;

            while (it.hasNext())
            {
                end = it.next();
                al.add(end);
            }

            Collections.sort(al);
            int sit = lower_bound(al, cSum - K);

            // Check if upper_bound
            // of (cSum-K) exists
            // then update max sum
            if (sit != end)
                max_sum = Math.max(max_sum,
                        cSum - sit);

            // Insert cumulative value in hash
            cum_set.add(cSum);
        }

        // Return maximum sum
        // lesser than K
        return max_sum;
    }

    static int lower_bound(ArrayList<Integer> al,
                           int x)
    {

        // x is the target value or key
        int l = -1, r = al.size();
        while (l + 1 < r)
        {
            int m = (l + r) >>> 1;
            if (al.get(m) >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }
}
