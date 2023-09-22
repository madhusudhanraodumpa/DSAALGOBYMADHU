package com.org.prep.backtracking;
import java.util.*;
import java.util.stream.Collectors;

public class AllSubSets {

public static void main(String args[]){
    AllSubSets a=new AllSubSets();
    int[] x={4,5};
    //a.subsets(x);
   // System.out.println(r);





}


    public List<List<Integer>> subsets(int[] a) {
        int n=a.length;
        List<List<Integer>> list=new LinkedList<>();
        List<Integer> l=new ArrayList<>();
        allSubsets(a,0,n,list,l);

        return list;
    }

    public void allSubsets(int[] a,int index,int n,List<List<Integer>> list,List<Integer> l){

        if(n==index){
            list.add(new ArrayList<>(l));
            return;
        }

        l.add(a[index]);
        allSubsets(a,index+1,n,list,l);
        l.remove(l.size()-1);
        allSubsets(a,index+1,n,list,l);




    }




    public int[][] subsetsWithDup(int[] A) {
        int n=A.length;
        Arrays.sort(A);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        subsets(A,n,0,subset,list);


        Set<Set<Integer>> sets=new HashSet<>();
        for(List l:list){
            sets.add(new HashSet<>(l));
        }

        list = sets.stream().map(ArrayList::new).collect(Collectors.toList());

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

        return list.stream().map(u ->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }

    public void subsets(int[] A,int n,int index,List<Integer> subset, List<List<Integer>> list){
        if(index==n){
            list.add(new ArrayList<>(subset));
            return;
        }
        subsets(A,n,index+1,subset,list);
        subset.add(A[index]);
        subsets(A,n,index+1,subset,list);
        subset.remove(subset.size()-1);

    }
}
