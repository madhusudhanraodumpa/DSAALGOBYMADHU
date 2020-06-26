package com.org.learnby.hash;

import java.util.HashSet;
import java.util.Set;

public class CheckSubarraySumWithZero {
    public static void main(String args[]){
        int a[]={4,-3,1,-2};
       System.out.println(checkSubarraySumZeroApproch1(a,a.length));
        System.out.println(checkSubarraySumZeroApproch2(a,a.length));

    }

    //bruteforce approch -- O(n^2)
    private static boolean checkSubarraySumZeroApproch1(int[] a, int n) {
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum==0){
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }

    //optimal opproch using hashset or hashmap-- O(n)
    private static boolean checkSubarraySumZeroApproch2(int[] a, int n) {
        Set<Integer> set=new HashSet<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
            if(sum==0 || set.contains(sum)){
                return true;
            }else{
                set.add(sum);
            }

        }



        return false;
    }
}
