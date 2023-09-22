package com.org.prep.array;

public class SubarrayswithBitwiseOR1 {
    public static void main(String args[]){
        int[] a={1,1,0,0,1};
        System.out.println(solve(5,a));
    }


    public static long solve(int A, int[] B) {

        int ans=0;
        int count=0;
        boolean flag=false;

        for(int i=0;i<A;i++){

            if(B[i]==0){

                count++;
                flag=true;

            }else{

                ans=ans+((count*(count+1))/2);
                count=0;

            }



        }
        if(count>0){
            ans=ans+((count*(count+1))/2);
        }
        if(!flag){
            return (A*(A+1))/2;
        }

        ans= (A*(A+1))/2-ans;
        return ans;
    }
}
