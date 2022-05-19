package com.org.learnby.array;

public class DutuchFlagPrinciple {
    public static void main(String rags[]){
        int[] arr={0,2,1,1,0,2,2,1,0,10};
        printFlagArray(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println(arr);

    }

    private static void printFlagArray(int[] arr) {

        int l=0;
        int m=0;
        int h=arr.length-1;

       while(m<=h){
            switch (arr[m]) {
                case 0:
                    swap(arr,l,m);
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(arr,m,h);
                    h--;
                    break;

            }

        }

    }
    private static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
