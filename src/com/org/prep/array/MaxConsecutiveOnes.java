package com.org.prep.array;

public class MaxConsecutiveOnes {


    public static void main(String[] args) {
        int[] a1={1,1,1,1,1,1,1,0,0,0};
        int k=2;
        System.out.println(longestOnes2(a1,k));
    }

    public static int longestOnes(int[] a, int k) {

        int n=a.length;
        int start=0;
        int end=0;
        int count=0;
        int maxOnes=Integer.MIN_VALUE;
        while(end<n){

            if(a[end]==0){
                count++;
            }

            while(count>k){
                if(a[start]==0){
                    count--;
                }
                start++;


            }





            maxOnes=Math.max(maxOnes,end-start+1);
            end++;






        }

        return maxOnes;
    }


    public static int longestOnes1(int[] a, int k) {

        int n = a.length;
        int start = 0;
        int end = 0;
        int count = 0;
        int maxOnes = Integer.MIN_VALUE;
        int c = k;

        for (int i = 0; i < n; i++) {
            c = k;
            for (int j = i; j < n; j++) {

                if (a[j] == 0) {
                    c--;
                }
                if (c < 0) {
                    break;
                }
                maxOnes = Math.max(maxOnes, j - i + 1);
            }


        }

        return maxOnes;
    }


    public static int longestOnes2(int[] a, int k) {
        int n = a.length;
        int start = 0;
        int end = 0;
        int count = 0;
        int maxOnes = 0;
        while (start < n && end < n) {
            if (a[end] == 0)
                count++;

            if (count > k) {
                if (a[start] == 0) {
                    count--;
                }
                start++;
            }
            if(count<=k) {
                maxOnes = Math.max(maxOnes, end - start + 1);
            }

            end++;
        }
        return maxOnes;
    }


}
