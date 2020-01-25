package com.org.leetcode.stack;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
          int[] days=new int[T.length];
          Stack<Integer> stack=new Stack<>();
          for(int i=0;i<T.length;i++){
              while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                  days[stack.peek()]=i-stack.pop();
              }
              stack.push(i);
          }
          return days;
    }
    public static void main(String args[]){
        DailyTemperatures_739 d=new DailyTemperatures_739();
        int temp[]={73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr=d.dailyTemperatures(temp);

        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
