package com.org.prep.array;

public class MaxProductSubarray {

    public static void main(String[] args){
        int a[]={0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        System.out.println(maxProduct(a));
    }
    private static int maxProduct(int a[]){
       long leftProduct=1;
       long rightProduct=1;
       int n=a.length;
       int i=0;
       int j=n-1;
       long result=Integer.MIN_VALUE;
       while(i<n && j>=0){

           leftProduct =leftProduct*a[i];
           rightProduct = rightProduct*a[j];

           result=Math.max(result,Math.max(leftProduct,rightProduct));
           if(leftProduct==0){
               leftProduct=1;
           }
           if(rightProduct==0){
               rightProduct=1;
           }


           i++;
           j--;

       }

       return (int)result;
    }

    private static int maxProduct1(int nums[]){
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swapping min and max
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }



            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);


            ans = Math.max(ans, max);
        }

        return ans;
    }

}
