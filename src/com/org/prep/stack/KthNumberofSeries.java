package com.org.prep.stack;

import java.util.LinkedList;
import java.util.Queue;

public class KthNumberofSeries {
    public static void main(String args[]){
        kthNumbers(7);
    }

    public static int[] kthNumbers(int A){
        int n=A;
        Queue<Integer> q=new LinkedList<>();

        int[] ans=new int[n];
        int count=3;
        int i=0;
        q.add(1);
        ans[i++]=1;
        q.add(2);
        ans[i++]=2;
        q.add(3);
        ans[i++]=3;

        while (count<A && true){

            String x=String.valueOf(q.remove());


            q.add(Integer.valueOf(x+'1'));
            ans[i++]=Integer.valueOf(x+'1');
            count++;
            if(count==A){
                break;
            }

            q.add(Integer.valueOf(x+'2'));
            ans[i++]=Integer.valueOf(x+'2');
            count++;
            if(count==A){
                break;
            }

            q.add(Integer.valueOf(x+'3'));
            ans[i++]=Integer.valueOf(x+'3');
            count++;
            if(count==A){
                break;
            }


        }
        return ans;
    }
}
