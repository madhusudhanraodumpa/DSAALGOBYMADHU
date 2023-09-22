package com.org.prep.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumPositivity {
    public static void main(String args[]){
          int[] a={ -5173778, -8176176, 1694510, 7089884, -1394259, 1146372, -2502339, 1544618, 6602022, 4330572};

        solve2(a);
        String s="";
       // s.charAt()
    }
    public static int[] solve1(int[] A) {

        int n = A.length;
        int start = 0;
        int end = 0;
        int startIndex = -1;
        int endIndex = n - 1;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;


        while (end < n) {

            while (end < n && A[end] < 0) {
                end++;
                start = end;
            }
            len = end - start + 1;
            if (maxLen < len) {
                maxLen = len;
                startIndex = start;
                endIndex = end;
            }
            end++;
        }
        List<Integer> list = new ArrayList<>();
        for (int k = startIndex; k <= endIndex; k++) {
            list.add(A[k]);
        }
        return list.stream().mapToInt(x -> x).toArray();
        }


    public static int[] solve(int[] A) {

            int maxOnes=Integer.MIN_VALUE;
            int n=A.length;

            int count=0;
            for(int i=0;i<n;i++){
                if(A[i]>0){
                    count=count+1;
                }
            }
            if(n==count) return A;

            int startIndex=0;
            int endIndex=0;
            int len=Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                if(A[i]<0){

                    int l=0;
                    int j=0;
                    for(j=i-1;j>=0;j--){

                        if(A[j]>0){
                            l++;
                        }else{
                            break;
                        }

                    }

                    int r=0;
                    int k=0;
                    for(k=i+1;k<n;k++){
                        if(A[k]>0){
                            r++;
                        }else{
                            break;
                        }

                    }

                    if(l>r){

                        if(len<i-1-j-1+1){
                            startIndex=j+1;
                            endIndex=i-1;
                            len=endIndex-startIndex+1;
                        }else if (len==i-1-j-1+1){

                            if(j+1<startIndex){
                                startIndex=j+1;
                                endIndex=i-1;
                            }
                        }
                    }
                    else if (r>l){

                        if(len<k-1-i-1+1){
                            startIndex=i+1;
                            endIndex=k-1;
                            len=endIndex-startIndex+1;
                        }else if(len==k-1-i-1+1){
                            if(i+1<startIndex){
                                startIndex=i+1;
                                endIndex=k-1;
                            }
                        }
                    }else if(l!=0 && l==r){
                        if(i+1<startIndex){
                            startIndex=i+1;
                            endIndex=k-1;
                        }
                        len=endIndex-startIndex+1;
                    }


                }



            }


            //  return maxOnes;


            List<Integer> list=new ArrayList<>();
            for(int k=startIndex;k<=endIndex;k++){
                list.add(A[k]);
            }

            return list.stream().mapToInt(x->x).toArray();

        }


    public static int[] solve2(int[] A) {

        /** int n=A.length;
         int start=0;
         int end=0;
         int startIndex=-1;
         int endIndex=n-1;
         int maxLen=Integer.MIN_VALUE;
         int len=0;


         while(end<n) {

         if (end < n && A[end] < 0) {
         end++;
         start = end;
         continue;
         }
         len = end - start + 1;
         if (maxLen < len) {
         maxLen = len;
         startIndex = start;
         endIndex = end;
         }
         end++;
         }
         List<Integer> list = new ArrayList<>();
         for (int k = startIndex; k <= endIndex; k++) {
         list.add(A[k]);
         }
         return list.stream().mapToInt(x -> x).toArray();**/

        int n=A.length;
        int startIndex=-1;
        int endIndex=-1;
        int start=0;
        int end=0;
        int len=Integer.MIN_VALUE;
        while(end<n){

            if(A[end]<0){
                if(end-start+1>len) {
                    startIndex = start;
                    endIndex = end - 1;
                    len=end-start;
                }
                start=end+1;


            }

            else if(end-start+1>len){
                len=end-start+1;
            }
            end++;


        }
        List<Integer> list = new ArrayList<>();
        for (int k = startIndex; k <= endIndex; k++) {
            list.add(A[k]);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}

