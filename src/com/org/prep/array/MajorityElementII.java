package com.org.prep.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElementII {

    public static void main(String args[]){
        int a[]={1000040, 1000459, 1000930, 1000040, 1000040, 1000301, 1000280, 1000106, 1000787, 1000040, 1000696, 1000378, 1000836, 1000040};
        List<Integer> list = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList());

        repeatedNumber(list);
        //Arrays.sort(A, Collections.reverseOrder());


    }

    public static int repeatedNumber(final List<Integer> a) {

        int[] A=a.stream().mapToInt(i -> i).toArray();
        int n=A.length;
        int ele1=A[0];
        int freq1=1;
        int ele2=-1;
        int freq2=0;

        for(int i=1;i<n;i++){

            if(ele1==A[i]){
                freq1++;
            }else if(ele2==A[i]){
                freq2++;
            }else{
                if(freq1==0){
                    ele1=A[i];
                    freq1++;
                }else if(freq2==0){
                    ele2=A[i];
                    freq2++;
                }else{
                    freq1--;
                    freq2--;
                }


            }




        }
        freq1=0;

        for(int i=0;i<n;i++){

            if(ele1==A[i]){
                freq1++;
            }
        }
        if(freq1>n/3) return ele1;

        freq2=0;

        for(int i=0;i<n;i++){

            if(ele2==A[i]){
                freq2++;
            }
        }
        if(freq2>n/3) return ele2;

        return -1;


    }


}
