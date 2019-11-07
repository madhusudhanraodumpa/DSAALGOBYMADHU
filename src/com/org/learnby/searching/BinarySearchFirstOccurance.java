package com.org.learnby.searching;

public class BinarySearchFirstOccurance {
    public static void main(String args[]){
        int a[]={1,2,2,2,2,3,3,4,4,4};
      System.out.println(firstOccuranceBS(a,0,a.length-1,4));


    }

    private static int firstOccuranceBS(int[] a, int s, int e, int searchElement) {

        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(a[mid]==searchElement){
                ans=mid;
                e=mid-1;
            }else if(a[mid]>searchElement){
                e=mid-1;
            }else{
                s=mid+1;
            }



        }
        return ans;
    }
}
