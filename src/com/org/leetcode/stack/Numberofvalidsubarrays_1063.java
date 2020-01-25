package com.org.leetcode.stack;

import java.util.Stack;

public class Numberofvalidsubarrays_1063 {
    public static void main(String args[]) {
        Numberofvalidsubarrays_1063 n = new Numberofvalidsubarrays_1063();
        int arr[] = {2, 2, 2};
        System.out.println(n.numberVaildSubArrays(arr));
    }

    public int numberVaildSubArrays(int arr[]) {
        int numOfVaildSubArrays = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || (!stack.isEmpty() && arr[stack.peek()] < arr[i])) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    numOfVaildSubArrays += i - stack.pop();

                }
                stack.push(i);

            }
        }
        while (!stack.isEmpty()) {
            numOfVaildSubArrays += i - stack.pop();
        }
        return numOfVaildSubArrays;

    }
}
