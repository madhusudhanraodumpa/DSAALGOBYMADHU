package com.org.learnby.array;

public class WaveOfArray {
    public static void main(String rags[]){
        int[] arr={5,3,4,8,2,1,9,6,7};
        waveOfArray(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println(arr);

    }



    private static void waveOfArray(int[] arr) {
        for(int i=0;i<arr.length;i+=2){

                if(i>0 && arr[i-1]>arr[i]){
                    swap(arr,i-1,i);
                }
                if(i<arr.length-1 && arr[i]<arr[i+1]){
                    swap(arr,i,i+1);
                }

            }
    }

    private static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
