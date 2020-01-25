package com.org.leetcode.arrays;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FourSum_18 {
    public static void main(String args[]) {
        FourSum_18 f = new FourSum_18();
        int arr[] = {-4,-3,-2,-1,0,0,1,2,3,4};


        List<List<Integer>> list = f.fourSum(arr, 0);
        System.out.println();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new CopyOnWriteArrayList<>();
        Set<List<Integer>> set=new HashSet<>();

        Map<Integer, Pair> mp = new HashMap<Integer, Pair>();
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                mp.put(nums[i] + nums[j], new Pair(i, j));
            }
        }
        for (int i = 0; i < n ; i++) {
           for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (mp.containsKey(target - sum)) {
                    Pair p = mp.get(target - sum);
                    if (p.i != i && p.i !=j &&
                            p.j != i && p.j != j) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[p.i]);
                        l.add(nums[p.j]);
                        System.out.println(l);
                      //  list.add(l);
                        if(list.size()==0){
                            list.add(l);
                        }else {
                            boolean flag=true;
                            for (List ll : list) {
                                if (ll.containsAll(l)) {
                                    flag=false;
                                    break;
                                }
                            }
                            if(flag){
                                list.add(l);
                            }
                        }

                    }
                }

            }
        }

        return list;
    }
}

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
