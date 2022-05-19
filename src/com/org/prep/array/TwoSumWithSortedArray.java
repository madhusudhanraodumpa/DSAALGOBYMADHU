package com.org.prep.array;

public class TwoSumWithSortedArray {
    public static void main(String[] args){

        System.out.println();
    }


    public static int[] twoSum(int[] a, int target) {

        int left=0;
        int right=a.length-1;
        int[] res=new int[2];

        while(left<right){

            if(left!=0 && a[left]==a[left-1]){
                left++;
                continue;

            }
            int sum=a[left]+a[right];
            if(sum==target){
                res[0]=left+1;
                res[1]=right+1;
                left++;
                right--;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }




        }
        return res;
    }
}
