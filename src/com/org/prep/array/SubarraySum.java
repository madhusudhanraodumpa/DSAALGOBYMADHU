package com.org.prep.array;

public class SubarraySum {

    public static void main(String[] args) {
        int a[] ={12,1,50,39,32,23,22,44,17,5,9,12,10,50,26,5,23,38,31,5,34,8,21,11,24,44,18,19,6,31,3,47,5,2,33,44,14,9};
        int[] ans=solve(a,52);
        System.out.println(ans);
    }



    public static int[] solve(int[] A, int B) {
        int n=A.length;
        int startIndex=-1;
        int endIndex=-1;
        int start=0;
        int end=0;
        int sum=0;

        while(end<n) {
            sum=sum+A[end];

            while(sum>B && start<end) {
                sum=sum-A[start];
                start++;
            }

            if(sum==B) {
                startIndex=start;
                endIndex=end;
                break;
            }


            end++;


        }

        int[] res;
        if(startIndex!=-1) {
            res=new int[endIndex-startIndex+1];
            int x=0;
            for(int i=startIndex;i<=endIndex;i++) {
                res[x++]=A[i];
            }
            return res;
        }
        else {
            res=new int[1];
            res[0]=-1;
            return res;
        }




    }
}
