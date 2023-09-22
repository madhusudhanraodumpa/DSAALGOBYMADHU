package com.org.prep.heap;
import java.util.*;
import java.util.stream.Collectors;

public class RunningMedian {

    public static void main(String[] args){
        RunningMedian r=new RunningMedian();
        int[] a={59, 64, 10, 39};
        List<List<Integer>> list=new ArrayList<>();

        Set<Set<Integer>> set = list.stream()
                .map(HashSet::new)
                .collect(Collectors.toSet());

        r.solve(a);
    }
    public int[] solve(int[] A) {
        PriorityQueue<Integer> secondHalf= new PriorityQueue<>();
        PriorityQueue<Integer> firstHalf  = new PriorityQueue<>(Collections.reverseOrder());
        int n=A.length;
        int[] ans=new int[n];
        ans[0]=A[0];
        firstHalf.add(A[0]);
        for(int i=1;i<n;i++){
            if(firstHalf.peek()>A[i]){
                firstHalf.add(A[i]);
            }else{
                secondHalf.add(A[i]);
            }

            if(firstHalf.size()<secondHalf.size()){
                int temp=secondHalf.peek();
                secondHalf.remove();
                firstHalf.add(temp);

            }else if(firstHalf.size()-secondHalf.size()>1){
                int temp1=firstHalf.peek();
                firstHalf.remove();
                secondHalf.add(temp1);

            }
            int index=i+1;

            if(index%2==0){

                int x= (firstHalf.peek()+secondHalf.peek())/2;
                ans[i]=x;
            }else{
                ans[i]=firstHalf.peek();
            }
        }

        return ans;

    }

}
