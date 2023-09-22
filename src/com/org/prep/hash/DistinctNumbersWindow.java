package com.org.prep.hash;
import java.util.*;

public class DistinctNumbersWindow {
    public static void main(String[] args){
        Integer a[]={1, 2, 1, 3, 4, 3};
        List<Integer> list=Arrays.asList(a);
        dNums(list,3);
    }
    public static ArrayList<Integer> dNums(List<Integer> A, int B) {
        Map<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();

        int n=A.size();
        int start=0;
        int end=0;
        while(end<B){
            map.put(A.get(end),map.getOrDefault(A.get(end),0)+1);
            end++;
        }
        list.add(map.size());
        while(end<n){
            map.put(A.get(start),map.get(A.get(start))-1);
            if(map.get(A.get(start))==0){
                map.remove(A.get(start));
            }
            map.put(A.get(end),map.getOrDefault(A.get(end),0)+1);
            start++;
            end++;
            list.add(map.size());
        }
        return list;
    }
}
