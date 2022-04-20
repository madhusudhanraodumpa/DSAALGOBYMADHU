package com.org.prep.stack;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String args[]){
        int a[]={0,1,0,1,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(a));
    }
    public static int trap(int[] height) {
        int trappingWater = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int poped = stack.pop();
                int area = 0;
                int dist = 0;
                if (!stack.isEmpty()) {
                    dist = i - stack.peek() - 1;
                    area = Math.min(height[i], height[stack.peek()]) - height[poped];
                }
                trappingWater = trappingWater + (dist * area);

            }


            if (!stack.isEmpty() && height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } else {
                stack.push(i);
            }


        }


        return trappingWater;
    }
}
