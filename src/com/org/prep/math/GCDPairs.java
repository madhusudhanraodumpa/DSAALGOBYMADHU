package com.org.prep.math;

import java.util.*;

public class GCDPairs {
    public static void main(String[] args) {
        int a[]={1,299,1,1,1,1,1,1,1,1,1,1,1,1,1,23,1,1,1,1,1,1,1,1,1,1,503,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,866,1,1,2,2,1,2,2,2,2,1,2,1,2,1,2,1,2,2,1,2,1,1,2,1,1,2,714,2,1,17,2,6,2,34,1,14,1,2,1,6,21,2,6,3,2,1,1,6,1,1,2,2,622,1,1,2,2,2,2,1,2,1,2,1,2,1,2,2,1,2,1,1,2,1,1,1,1,1,131,1,1,1,1,1,1,1,1,1,1,1,1,1,1,131,1,1,1,1,1,1,1,17,1,1,187,1,11,1,17,11,1,1,1,1,1,11,1,11,1,1,1,1,1,1,1,2,2,2,1,1,256,4,4,8,1,2,1,4,1,16,1,2,8,1,4,1,1,2,1,1,2,6,2,1,11,4,396,4,4,11,2,1,4,1,36,99,2,396,3,4,1,1,18,1,1,2,2,2,1,1,4,4,596,4,1,2,1,4,1,4,1,2,4,1,4,1,1,2,1,1,2,34,2,1,17,8,4,4,136,1,2,1,4,1,8,1,2,8,1,4,1,1,2,1,1,1,1,1,1,11,1,11,1,1,407,1,1,1,1,1,11,37,11,1,1,1,1,1,1,1,2,14,2,1,1,2,2,2,2,1,994,1,2,1,2,7,2,2,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,521,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,4,4,4,4,1,2,1,692,1,4,1,2,4,1,4,1,1,2,23,1,1,1,1,1,1,1,1,1,1,1,1,1,1,713,1,1,1,1,1,1,1,1,1,1,1,2,6,2,1,1,16,36,4,8,1,2,1,4,1,720,9,2,72,3,4,1,5,18,1,1,1,21,1,1,11,1,99,1,1,11,7,1,1,1,9,693,1,99,3,1,1,1,9,1,1,2,2,2,1,1,2,2,2,2,37,2,1,2,1,2,1,74,2,1,2,1,1,2,1,1,2,6,2,1,11,8,396,4,8,11,2,1,4,1,72,99,2,792,3,4,1,1,18,1,1,1,3,1,131,1,1,3,1,1,1,1,1,1,1,3,3,1,3,393,1,1,1,3,1,1,2,2,2,1,1,4,4,4,4,1,2,1,4,1,4,1,2,4,1,556,1,139,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,103,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,139,1,1,695,1,1,1,2,6,2,1,1,2,18,2,2,1,2,1,2,1,18,9,2,18,3,2,1,1,738};
        int[] x= gcdPairs(a);
        System.out.println(x);
    }

    private static int[] gcdPairs(int[] a) {
        a = Arrays.stream(a).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(a);
        int x=a.length;
        int n= (int) Math.sqrt(x);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<x;i++) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        while (list.size()!=n){
            int maxEle=Integer.MIN_VALUE;
            for(Integer ele :map.keySet()) {
              maxEle= Math.max(maxEle,ele);
            }
            map.put(maxEle,map.get(maxEle)-1);
            if(map.get(maxEle)==0) {
                map.remove(maxEle);
            }
            for (int j=0;j<list.size();j++) {
                int y = gcd(a[j],maxEle);
                if(map.containsKey(y)) {
                    map.put(y, map.get(y) - 2);

                    if (map.get(y) == 0) {
                        map.remove(y);
                        System.out.println(list.size());
                    }
                }
            }
            list.add(maxEle);

        }
    return list.stream().mapToInt(i->i).toArray();


    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
