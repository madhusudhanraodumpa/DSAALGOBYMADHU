package com.org.prep.sliding;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeNumberineveryWindow {
    public static void main(String args[]){
        int a[]={12,-1,-7,8,-15,30,16,28};
        System.out.println(firstNegativeNumberinArray(3,a));
    }
    private static int firstNegativeNumberinArray(int i, int[] a) {
        int k = i;

        int start = 0;
        int end = 0;
        Deque<Integer> dq=new LinkedList<>();

        while(end<a.length){
            if(a[end]<0){
                dq.addLast(a[end]);
            }
            if(end-start+1<k){
                end++;
            }else if(end-start+1 == k){
                if(dq.isEmpty()){
                    System.out.print(0+" ");
                }else{
                  System.out.print(dq.peekFirst()+" ");
                }
                end++;
                if(!dq.isEmpty() && a[start] ==  dq.peekFirst()){
                    dq.removeFirst();
                }
                start++;
            }


        }
        return -1;
    }
}
