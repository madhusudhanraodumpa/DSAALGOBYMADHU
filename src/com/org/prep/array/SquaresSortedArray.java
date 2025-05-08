package com.org.prep.array;

public class SquaresSortedArray {
    public static void main(String[] args) {

        int[] a={-7,-3,2,3,11};
        sortedSquares(a);
    }
    public static int[] sortedSquares(int[] nums) {

        int n=nums.length;

        int i=0;
        int j=n-1;
        int k=n-1;

        int res[]=new int[n];
        while(i<=j) {

            int x=nums[i]*nums[i];
            int y=nums[j]*nums[j];

            if(x<y) {
                res[k]=y;
                k--;
                j--;
            }else {
                res[k]=x;
                k--;
                i++;
            }



        }
        return res;
    }
}
