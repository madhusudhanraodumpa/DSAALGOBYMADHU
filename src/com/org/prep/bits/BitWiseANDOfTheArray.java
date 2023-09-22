package com.org.prep.bits;

public class BitWiseANDOfTheArray {
    public static void main(String args[]){
        int[] a={3,1,2,7};
        System.out.println(minModification(a,2));
    }


    public static int minModification(int a[],int x){
        int n=a.length;
        int bitsetinX=0;
        int ans=Integer.MAX_VALUE;

        for(int i=30;i>=0;i--){

            if(((x>>i)&1)==1){
                bitsetinX=bitsetinX | (1<<i);



            }else{

                int temp=bitsetinX;
                temp=temp|(1<<i);
                int dontModify=0;
                for(int j=0;j<n;j++){
                    if((a[j] & temp) ==temp){
                        dontModify++;
                    }


                }

                ans=Math.min(ans,n-dontModify);

            }



        }


        return  ans;



    }

}
