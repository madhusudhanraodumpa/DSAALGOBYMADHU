package com.org.prep.bits;

public class SumOfAllBitWiseANDPairs {
    public static void main(String args[]){
        int a[]={5,10,15};
        System.out.println(sumPair(a));

    }


    public static int sumPair(int a[]){
        int n=a.length;
        int ans=0;
        for(int i=0;i<31;i++){

            int count=0;
            for(int j=0;j<n;j++){
                if(((a[j]>>i) &1)==1){
                    count++;
                }
            }
            count=count*(count-1)/2;
            ans=ans+count*(1<<i);

        }
        return ans;
    }
}
