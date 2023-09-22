package com.org.prep.backtracking;
import java.util.*;
import java.util.stream.Collectors;

public class PermutationSequence {



    public static void main(String args[]){
        PermutationSequence p=new PermutationSequence();
        p.getPermutation(3,3);
    }

    public String getPermutation(int n, int k) {

        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }

        List<List<Integer>> list=new ArrayList<>();
        permute(a,0,n,list);


        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> first, List<Integer> second) {
                int comp = 0;
                for(int i = 0; i < Math.min(first.size(), second.size()); i++){
                    comp = Integer.compare(first.get(i), second.get(i));
                    if(comp != 0){
                        return comp;
                    }
                }
                return Integer.compare(first.size(), second.size());
            }
        });

        return String.valueOf(list.get(k));





    }


    public void permute(int[] a,int index,int n,List<List<Integer>> list){

        if(index==n-1){

            List<Integer> l=Arrays.stream(a).boxed().collect(Collectors.toList());;
            list.add(l);
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
