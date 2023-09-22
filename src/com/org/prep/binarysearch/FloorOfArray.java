package com.org.prep.binarysearch;

public class FloorOfArray {
    public static void main(String[] args){
        long[] a={35,36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113};
        findFloor(a,10,10);
    }


    static int findFloor(long arr[], int n, long x)
    {

        int l=0;
        int h=n-1;
        int ans=-1;

        while(l<=h){
            int m=(l+h)/2;

            if(arr[m]==x) return (int)x;

            else if(arr[m]>x){
                h=m-1;
            }else{
                ans=(int)arr[m];
                l=m+1;
            }
        }

        return ans;

    }
}
