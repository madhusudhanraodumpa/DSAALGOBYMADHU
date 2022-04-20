package com.org.prep.binarysearch;

public class FindElementInSortedRotated {
    public static void main(String args[]){
        int a[]={3,1};

        System.out.println(search(a,3));
    }

    public static int search(int[] a, int target) {
        int index=findMin(a);
        int x=binarySearch(a,0,index-1,target);
        int y=binarySearch(a,index+1,a.length-1,target);
        if(x>0) return x;
        else return y;

    }

    public static int binarySearch(int[] a,int start,int end,int target){


        while(start<=end){
            int mid=start+(end-start)/2;

            if(a[mid]==target){
                return mid;
            }
            if(a[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static int findMin(int[] a) {
        // If the list has just one element then return that element.
        if (a.length == 1) {
            return 0;
        }


        int start = 0, end = a.length - 1;


        if (a[end] > a[0]) {
            return 0;
        }


        while (end >= start) {

            int mid = start + (end - start) / 2;

            if (a[mid] > a[mid + 1]) {
                return mid + 1;
            }
            if (a[mid - 1] > a[mid]) {
                return mid;
            }
            if (a[mid] > a[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
