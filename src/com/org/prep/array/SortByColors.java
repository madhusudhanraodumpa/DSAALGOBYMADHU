package com.org.prep.array;

public class SortByColors {
    public static void main(String[] args){
        int a[]={2,0,2,1,1,0};
        sortColors2(a);
    }
    public static void sortColors2(int[] A) {
        int n=A.length;
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++){
            if(A[i]==0) count0++;
            else if(A[i]==1) count1++;
            else count2++;
        }
        int k=0;
        if(count0>=0){
            A[k++]=0;
            count0--;
        }

        if(count1>=0){
            A[k++]=1;
            count1--;
        }

        if(count2>=0){
            A[k++]=2;
            count2--;
        }
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
