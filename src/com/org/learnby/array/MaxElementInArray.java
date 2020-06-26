package com.org.learnby.array;

public class MaxElementInArray {
    public static void main(String rags[]){
        int[] arr={5,3,4,8,2,1,9,6,7};
        System.out.println(findMaxElement(arr));
    }

    private static int findMaxElement(int[] arr) {
        int maxElement=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(maxElement<arr[i]){
                maxElement=arr[i];
            }
        }
        return maxElement;
    }

}
