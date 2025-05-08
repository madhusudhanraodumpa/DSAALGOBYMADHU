package com.org.prep.queue;
import java.util.*;

public class CountNDecSubarrays {
    public static void main(String[] args) {
        int a[]={6,3,1,2,4,4};
        System.out.println(countNonDecreasingSubarrays(a,7));
    }
    public static long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long operation=0;
        int left=n-1;
        int right=left;
        long ans=0;
        Deque<Pair> dq=new LinkedList<>();
        while(left>=0){
            int currentValue=nums[left];
            int popCount=0;
            while(!dq.isEmpty() && dq.peekFirst().val<=currentValue){
                Pair p=dq.peekFirst();
                dq.pollFirst();
                operation=operation+(currentValue-p.val)*1L*p.count;
                popCount=popCount+p.count;
            }
            dq.addFirst(new Pair(currentValue,popCount+1));

            if(operation<=k){
                ans=ans+right-left+1;
            }else{
                while(left<right && operation>k){

                    Pair p=  dq.peekLast();
                    operation=operation-(p.val-nums[right]);
                    dq.pollLast();
                    if(p.count-1>0){
                        p=new Pair(p.val,p.count-1);
                        dq.addLast(p);

                    }
                    right--;
                }

                ans=ans+right-left+1;
            }
            left--;
        }
        return ans;

    }
    static class Pair{
        int val;
        int count;
        public Pair(int val,int count){
            this.val=val;
            this.count=count;
        }
    }

    public static long countNonDecreasingSubarrays1(int[] nums, int k) {
        int n=nums.length;
        int count=1;
        int operation=0;
        int left=0;
        int right=1;
        while(right<n){
            if(nums[left]<nums[right]){
                count=count+right-left+1;
            }else{
                operation= operation + nums[left]-nums[right];
                if(k>=operation){
                    count=count+right-left+1;
                }else{
                    left++;
                    operation=0;
                    right=left;
                }
            }
            right++;

        }
        return count;

    }
}
