package com.org.prep.heap;
import java.util.*;
public class TaskSchedule {
    public static void main(String[] args) {
        char[] ch={'A','B','C','D','E','F'};
        System.out.println(leastInterval(ch,2));

    }
    public static int leastInterval(char[] tasks, int n) {
        int l=tasks.length;
        Map<Character,Integer> map=new HashMap<>();
        for(char ch: tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        p.addAll(map.values());
        int time=0;
        while(!p.isEmpty()){
            int cycle=n+1;
            List<Integer> temp=new ArrayList<>();
            int taskCount=0;
            while(cycle>0 && !p.isEmpty()){
                int val=p.poll();
                if(val>1){
                    temp.add(val-1);
                }
                taskCount++;
                cycle--;
            }
            p.addAll(temp);
            time=time+(p.isEmpty()?taskCount:n+1);


        }

        return time;

    }
}
