package com.org.prep.array;

public class FirstMissingPositive {
        public static void main(String args[]){
            int a[]={3,4,-1,0,1};
           System.out.println(firstMissingPositive(a));
        }

        //approch 1: O(n^2)  for each value from 1 to n  we have search in array linearly .
        //approch 2: O(nlogn) we have to sort the array and loop it and check any element is missing.
        //approch 3 : O(n) and O(n) space: first loop add array elements in to hashset. and then second time start form i is 1 to n and check i is present in hashset or not if not return i. or else n+1;
        //approch 4: O(n) first mark the out range array element to addy  any value like 1. And also check 1 is present in array. second time mark the array index element to -1. and 3 rd time loop the array from i 0 to n . if any element non negative then return i+1 or else n+1

    public static int firstMissingPositive(int[] nums) {


            int n=nums.length;

            boolean ones=false;
            for(int i=0;i<n;i++){

                if(nums[i]==1){
                    ones=true;
                }
                if(nums[i]<1 || nums[i]>n){
                    nums[i]=1;
                }


            }

            for(int i=0;i<n;i++){
                if(!ones) return 1;

                int index=Math.abs(nums[i]);

                nums[index-1]=-Math.abs(nums[index-1]);
            }

            for (int i=0;i<n;i++){
                if(nums[i]>0){
                    return i+1;
                }



            }
        return n+1;

    }
}
