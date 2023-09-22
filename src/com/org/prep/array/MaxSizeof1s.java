package com.org.prep.array;

public class MaxSizeof1s {


    public static void main(String rags[]){
        flip("010");
    }

    public static int[] flip(String A) {

        int n=A.length();

        int res[]=new int[n];
        boolean zeroFlag=false;

        for(int i=0;i<n;i++){
            if(A.charAt(i)-'0'==0){
                res[i]=1;
                zeroFlag=true;
            }else{
                res[i]=-1;
            }
        }
        if(!zeroFlag){
            int[] ans={};
            return ans;
        }


        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        int left=0;
        int right=0;
        int ans1[]=new int[2];
        for(int i=0;i<n;i++){

            sum=sum+res[i];
            //maxsum=Math.maxsum(sum,maxsum);

            if(sum<maxsum){

                maxsum=sum;
                right=i;
                ans1[0]=left+1;
                ans1[1]=right+1;


            }
            if(sum<0){
                sum=0;
                left=i+1;
            }



        }

        return ans1;

    }
}
