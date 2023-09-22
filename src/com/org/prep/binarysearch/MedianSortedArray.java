package com.org.prep.binarysearch;
import java.util.*;

public class MedianSortedArray {
    public static void main(String args[]){

        List<Integer> a=Arrays.asList(2);
        List<Integer>b=Arrays.asList();
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        if (a.size() > b.size()) {
         //   return findMedianSortedArrays(b, a);
        }
        int n1=a.size();
        int n2=b.size();
        int l=0;
        int h=n1;
        while(l<=h){
            int cut1=(l+h)/2;
            int cut2=(n1+n2)/2-cut1;

            int l1=cut1==0?Integer.MIN_VALUE:a.get(cut1-1);
            int l2=cut2==0?Integer.MIN_VALUE:b.get(cut2-1);
            int r1=cut1==n1?Integer.MAX_VALUE:a.get(cut1);
            int r2=cut2==n2?Integer.MAX_VALUE:b.get(cut2);

            if(l1<=r2 && l2<=r1){

                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2) !=Integer.MIN_VALUE ? Math.max(l1,l2):Math.min(r1,r2);
                }
            }else if(l1>r2){
                h=cut1-1;
            }else{
                l=cut1+1;
            }



        }

        return 0.0;

    }
}
