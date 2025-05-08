package com.org.prep.queue;
import java.util.*;

public class ConstrainedSubsequenceSum{
    public static void main(String[] args) {
        int a[]={-5266,4019,7336,-3681,-5767};
        System.out.println(constrainedSubsetSum(a,2));
    }

    public static int constrainedSubsetSum(int[] A, int k) {
        int n=A.length;
        Deque<Integer> q=new LinkedList<>();
        int c=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=k;i++){
            int x=A[i]+(q.isEmpty() ? 0:q.peekFirst());
            while(!q.isEmpty() && q.peekLast()<x){
                q.pollLast();
            }

            q.offerLast(x);

            A[i]=q.peekLast();
            ans=Math.max(ans,A[i]);
        }

        int l=1;
        int r=k+1;
        while(r<n){
            if(!q.isEmpty() && q.peekFirst()==A[l-1]){
                q.pollFirst();
            }
            int x=A[r]+(q.isEmpty() ? 0:q.peekFirst());

            while(!q.isEmpty() && q.peekLast()<x){
                q.pollLast();
            }
            q.offerLast(x);


            A[r]=q.peekLast();
            ans=Math.max(ans,A[r]);
            l++;
            r++;
        }



        return ans;

    }
    public static int constrainedSubsetSum2(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        int ans=nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[1]+dp[0]);
        for(int i=2;i<n;i++){

            int j=i;
            int prevK=k;

           int val=Integer.MIN_VALUE;
            while(j>=0 && prevK>=0){
                    val=Math.max(val,dp[j]);
                j--;
                prevK--;
            }

            dp[i]=Math.max(val+nums[i],nums[i]);


            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
public static int constrainedSubsetSum1(int[] A, int k) {
    int res = A[0];
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < A.length; ++i) {
        A[i] += !q.isEmpty() ? q.peek() : 0;
        res = Math.max(res, A[i]);
        while (!q.isEmpty() && A[i] > q.peekLast())
            q.pollLast();
        if (A[i] > 0)
            q.offer(A[i]);
        if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
            q.poll();
    }
    return res;

}
}
