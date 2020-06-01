package com.org.learnby.bitmasking;

public class FindThreeIniqueNumbers {
    public static void main(String args[]){
        int a[]={1,1,1,2,2,2,6};
        findTwoUniqueNumbers(a);
    }

    private static void findTwoUniqueNumbers(int[] a) {
       int[] count=new int[64];
       for(int i:a){
           int j=0;
           while(i>0){
               int last_bit= (i & 1);
               count[j]+=last_bit;
               j++;

               i=i>>1;
           }
       }
       int p=1;
       int ans=0;
       for(int i=0;i<64;i++){
           count[i]=count[i]%3;
           ans+=count[i]*p;
           p = p<<1;
       }
       System.out.println(ans);


    }
}
