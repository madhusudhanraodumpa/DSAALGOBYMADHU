package com.org.prep.heap;
import java.util.*;

public class NMaxPairCombinations {

    public int[] solve(int[] A, int[] B) {

        int N=A.length;
        int K=B.length;
        A=Arrays.stream(A).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        B=Arrays.stream(B).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        // for descending order
        int t=0;
        int ans[]=new int[N];
        PriorityQueue<Integer> p =
                new PriorityQueue<Integer>();

        // insert all the possible
        // combinations in max heap.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val=A[i]+B[j];
                if (p.size() < N) {
                    p.add(val);
                } else {
                    if (val > p.peek()) {
                        p.poll();
                        p.add(val);
                    } else {
                        break;
                    }
                }
            }
        }
        int i=0;
        while(!p.isEmpty()){
            ans[i++]=p.poll();
        }


        // pop first N elements
        // from max heap and
        // display them.

        return ans;
    }
    class CustomComp implements Comparator <Integer > {
        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    }
}
