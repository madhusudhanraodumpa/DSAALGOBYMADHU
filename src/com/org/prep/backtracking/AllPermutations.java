package com.org.prep.backtracking;
import java.util.*;

public class AllPermutations {
    public static void main(String args[]){
        int[] a={1,2,3};
        AllPermutations all=new AllPermutations();
        all.permute(a);

    }




    public int[][] permute(int[] A) {
        int n=A.length;
        List<int[]> list=new ArrayList<>();
        int[][] res=new int[list.size()][];
        permute(A,0,n,list);
        return list.toArray(res);

    }
    public void permute(int[] a,int index,int n,List<int[]> list){

        if(index==n-1)
        {
            int[] res=Arrays.copyOf(a, 3);
            list.add(res);
            return;
        }



        for(int j=index;j<n;j++){
            swap(a,index,j);
            permute(a,index+1,n,list);
            swap(a,index,j);

        }


    }

    public void swap(int a[],int t1,int t2){

        int t=a[t1];
        a[t1]=a[t2];
        a[t2]=t;
    }
}
