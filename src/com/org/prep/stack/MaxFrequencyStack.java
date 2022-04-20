package com.org.prep.stack;


import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {
   Map<Integer,Integer> frequencyMap;
   Map<Integer, Stack<Integer>> stackMap;
   int maxFrequency= Integer.MIN_VALUE;
   public MaxFrequencyStack(){
       frequencyMap=new HashMap<>();
       stackMap=new HashMap<>();
   }

    public void push(int x){
       int freq= frequencyMap.getOrDefault(x,0)+1;
       maxFrequency=Math.max(freq,maxFrequency);
        frequencyMap.put(x,freq);

        if(!stackMap.containsKey(freq)){
            stackMap.put(x,new Stack<>());
        }
        stackMap.get(freq).push(x);


    }
    public int pop(){
       int val = stackMap.get(maxFrequency).pop();
       frequencyMap.put(val,frequencyMap.get(val)-1);
       if(stackMap.get(maxFrequency).isEmpty()){
           maxFrequency--;
       }
       return val;

    }
}
