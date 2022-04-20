package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayofsumK {

    public static void main(String args[]) {
        int a[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        //System.out.println(largestSubarrayOfSumK(7, a));
        System.out.println(largestSubarrayOfSumK(0, a));

    }

    private static int largestSubarrayOfSumK(int i, int[] a) {
        int largest = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int k = i;
        int sum = 0;
        while (end<a.length){
            sum = sum+a[end];
            if(sum<k){
                end++;
            }
            if(sum==k){
                largest = Math.max(largest,end-start+1);
                end++;
            }
            else if(sum>k){


                while (sum>k){
                    sum = sum-a[start];
                    start++;
                    if(sum==k){
                        largest = Math.max(largest,end-start+1);
                    }
                }
                end++;
            }

        }
        return largest;
    }
    private static int largestSubarrayOfSumKNeg(int k, int[] a) {
        int count = 0, prefix_sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            prefix_sum =prefix_sum + a[i];
            if (map.containsKey(prefix_sum - k))
                count = count + map.get(prefix_sum-k);
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;

    }
}
