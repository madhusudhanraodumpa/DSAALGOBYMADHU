package com.org.prep.array;

public class SortByColors {
    public static void main(String[] args){
        int a[]={2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2};
        sortColors1(a);
    }


    public static void sortColors(int[] A) {
        int n=A.length;
        int[] B=new int[n];
        //  if(n==1) return A;
        int left=0;
        int right=n-1;


        int mid=0;

        while(mid<=right){

            if(A[mid]==0){
                swap(left,mid,A);
                left++;
                mid++;

            }else if(A[mid]==1){
                mid++;
            }else{
                swap(right,mid,A);
                right--;
            }


        }



    }

    public static void swap(int i, int j, int[] arr){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

    public static int[] sortColors1(int[] A) {

        int n=A.length;
        int[] B=new int[n];
        if(n==1) return A;
        int left=0;
        int right=n-1;


        int i=0;
        while(left<right && i<right){

            if(A[i]==0){
                swap(left,i,A);
                left++;

            }else if(A[i]==2){
                swap(right,i,A);
                right--;
                i--;

            }
            i++;



        }






        return A;
    }
}
