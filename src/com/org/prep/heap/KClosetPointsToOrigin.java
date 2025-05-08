package com.org.prep.heap;
import java.util.*;

public class KClosetPointsToOrigin {
    public static void main(String[] args) {
        KClosetPointsToOrigin closetPointsToOrigin = new KClosetPointsToOrigin();
        int[][] a={{1,3},{-2,2}};
        closetPointsToOrigin.kClosest(a,1);
    }
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<Pair1> p = new PriorityQueue<>(new CustomComp1());
        int[][] ans=new int[k][2];
        for(int i=0;i<n;i++){
            int[] point=points[i];

            int x=point[0];
            int y=point[1];
            int distance= x*x + y*y;
            Pair1 pair=new Pair1(distance,new int[]{x,y});
            if(p.size()<k){
                p.add(pair);
            }else{
                if(p.peek().val>distance){
                    p.poll();
                    p.add(pair);

                }else{
                    continue;
                }
            }
        }

        while(!p.isEmpty() && k>0){
            ans[k-1] =p.poll().cordinates;
            k--;
        }
        return ans;

    }
}
class Pair1{
    public int val;
    public int[] cordinates;
    public Pair1(int val,int[] cordinates){
        this.val=val;
        this.cordinates=cordinates;
    }
}
class CustomComp1 implements Comparator < Pair1 > {
    @Override
    public int compare(Pair1 a, Pair1 b) {
        return b.val-a.val;
    }
}