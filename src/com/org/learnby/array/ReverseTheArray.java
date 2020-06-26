package com.org.learnby.array;

public class ReverseTheArray {
    public static void main(String rags[]){
        int[] arr={5,3,4,8,2,1,9,6,7};
        reverseArray(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println(arr);

    }

    private static void reverseArray(int[] arr) {

        for(int i=0,j=arr.length-1;i<(arr.length-1)/2 && j/2>0;i++,j--){
            swap(arr,i,j);
        }

    }
    private static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
