package com.org.prep.heap;
import java.util.*;

public class FindPairKSmallestSums {
    public static void main(String[] args) {
        FindPairKSmallestSums findPairKSmallestSums =new FindPairKSmallestSums();
        int[] a={1,7,11};
        int[] b={2,4,6};
        findPairKSmallestSums.kSmallestPairs(a,b,3);

    }
    public  List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length;
        int n2=nums2.length;
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<Pair> p= new PriorityQueue<>( new CustomComp());
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int x=nums1[i]+nums2[j];
                if(p.size()<k){
                    Pair pair=new Pair(x,nums1[i],nums2[j]);
                    p.add(pair);
                }else{
                    if(!p.isEmpty() && p.peek().val>x){
                        p.poll();
                        Pair pair1=new Pair(x,nums1[i],nums2[j]);
                        p.add(pair1);
                    }
                }
            }
        }
        while(!p.isEmpty()){
            Pair p1=p.poll();
            List<Integer> list=new ArrayList<>();
            list.add(p1.i);
            list.add(p1.j);
            ans.add(list);
        }
        return ans;
    }
    class Pair{
        int val;
        int i;
        int j;
        public Pair(int val,int i,int j){
            this.val=val;
            this.i=i;
            this.j=j;
        }
    }
    class CustomComp implements Comparator < Pair > {
        @Override
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }
}
