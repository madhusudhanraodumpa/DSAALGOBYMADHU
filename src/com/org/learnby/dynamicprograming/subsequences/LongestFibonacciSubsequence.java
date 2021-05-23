package com.org.learnby.dynamicprograming.subsequences;

import java.util.*;

public class LongestFibonacciSubsequence {
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseqDpOpt(a));
    }
    public static int lenLongestFibSubseq(int[] A) {
        HashSet<Integer> nums = new HashSet<>();
        for (int i : A) {
            nums.add(i);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                long prev = A[j];
                long current = A[i] + A[j];
                int len = 3;
                while (current <= 1000000000 && nums.contains((int)current)) {
                    current += prev;
                    prev = current - prev;
                    res = Math.max(res, len++);
                }
            }
        }
        return res;
    }

    public static int lenLongestFibSubseqDp(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    public static int lenLongestFibSubseqDpOpt(int[] A) {
        if(A==null || A.length==0) return 0;
        int len=A.length;
        int dp[][]=new int[len][len];

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(A[i],i);
            for(int j=i+1;j<len;j++){
                dp[i][j]=2;
            }
        }

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int k=A[i]+A[j];
                if(map.containsKey(k)){
                    int index=map.get(k);
                    dp[j][index]=dp[i][j]+1;

                }
            }
        }
        int res=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++) {
            res=Math.max(res,dp[i][j]);
            }
            }
        return res==2 ?0:res;
    }

    // revision

    public static int lengthFibonicSubSequence(int a[], int n){
        Set<Integer> set = new TreeSet<>();
        for(int i =0;i<n;i++){
            set.add(a[i]);
        }
        int maxLen = 2;
        for( int i = 0;i<n;i++){
            for(int j =i+1;j<n;j++){
                int len = 2;
                int x = a[i];
                int y = a[j];
                while(set.contains(x+y)){
                    len++;
                   int temp = x+y;
                   x = y;
                   y = temp;
                }
                if(len>maxLen){
                    maxLen =len;
                }


            }
        }
        return maxLen;
    }
    }
