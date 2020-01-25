package com.org.leetcode.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack_895 {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public MaximumFrequencyStack_895() {
        freq = new HashMap<>();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int fre=freq.getOrDefault(x,0)+1;
        freq.put(x,fre);
        if(fre>maxfreq){
            maxfreq=fre;
        }
        group.computeIfAbsent(fre,z->new Stack<>()).push(x);

    }

    public int pop() {
        int x=group.get(maxfreq).pop();
        freq.put(x,freq.get(x)-1);
        if(group.get(maxfreq).size()==0){
            maxfreq--;
        }
        return x;

    }
    public static void main(String[] args){
        MaximumFrequencyStack_895 s=new MaximumFrequencyStack_895();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());



    }
}
