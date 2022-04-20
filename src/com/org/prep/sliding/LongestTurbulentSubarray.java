package com.org.prep.sliding;

public class LongestTurbulentSubarray {

    public static void main(String args[]){
        int a[]={2,0,2,4,2,5,0,1,2,3};
        System.out.println(maxTurbulenceSize(a));
    }

    public static int maxTurbulenceSize(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int down=1; int up=1;
        int max = 0;
        boolean flag1 = nums[1]>nums[0]?false:true;
        for(int i=1;i<nums.length;i++){

            if(nums[i]>nums[i-1]){

                if(!flag1) {
                    flag1 = true;
                    up = down + 1;
                }else{
                    max= Math.max(max,Math.max(up,down));
                    up =2;
                    down=1;
                }


            }
            else if(nums[i]<nums[i-1]){
                if(flag1) {
                    down = up + 1;
                    flag1 = false;
                }else{
                    max= Math.max(max,Math.max(up,down));
                    up =1;
                    down=2;
                }
            } else if (nums[i]== nums[i-1]){

                max= Math.max(max,Math.max(up,down));
                up = 1;
                down =1;
            }

        }
        return  Math.max(Math.max(up,down),max);
    }
}
