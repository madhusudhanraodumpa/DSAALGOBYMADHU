package com.org.learnby.dynamicprograming.subsequences;

public class WiggleSubSequence {
    public static void main(String args[]){
        int a[]={1,7,4,9,2,5};
        System.out.println(wiggleMaxLengthOpt(a));
    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public static int wiggleMaxLengthOpt(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int down=1; int up=1;
        for(int i=1;i<nums.length;i++){

            if(nums[i]>nums[i-1]){
                up=down+1;
            }
            if(nums[i]<nums[i-1]){
                down=up+1;
            }
        }
        return  Math.max(up,down);

    }
}
