package com.org.prep.array;

public class NiceSubarray {

    public static void main(String args[]){
        NiceSubarray n=new NiceSubarray();
        int a[]={2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(n.niceSubarrays(a,k));

    }

    public int niceSubarrays(int nums[],int k){
        int i=0;
        int j=0;
        int oddCount=0;
        int count=0;
        int temp=0;

        while(j<nums.length){
            if(nums[j]%2==1){
                oddCount++;
                temp=0;
            }
            while(oddCount==k){
                temp++;
                if(nums[i]%2==1){
                    oddCount--;
                }
                i++;
            }
            count+=temp;
            j++;
        }
        return count;
    }
}
