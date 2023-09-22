package com.org.prep.array;

public class TrappingRainWater {
    public static void main(String args[]){

        int a[]={2,0,4,0,3,2,0,5,2,1,3};
        trap(a);
    }


    public static int trap(int[] height){
    int n=height.length;
    int left=0;
    int right=n-1;
    int leftbar=height[left];
    int rightbar=height[right];


    int trap=0;
        while(left<=right){
        leftbar=Math.max(leftbar,height[left]);
        rightbar=Math.max(rightbar,height[right]);
        if(leftbar<rightbar){

            trap=trap+(Math.min(leftbar,rightbar)-height[left]);
            left++;

        }else{
            trap=trap+(Math.min(leftbar,rightbar)-height[right]);
            right--;
        }


    }

        return trap;


}
}
