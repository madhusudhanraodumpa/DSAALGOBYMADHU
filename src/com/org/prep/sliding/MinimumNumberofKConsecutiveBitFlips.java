package com.org.prep.sliding;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberofKConsecutiveBitFlips {
    public static void main(String[] args){
        int a[]={0,0,0,1,0,1,1,0};
        System.out.println(minKBitFlips(a,3));

    }


    public static int minKBitFlips(int[] A, int K) {

        //flipIndex: store previous flip events
        Queue<Integer> flipIndex = new LinkedList<>();
        int ans = 0;
        for(int i = 0;i<A.length;i++){
            // remove an itme which is out range of window.
            if(!flipIndex.isEmpty()&&(i-flipIndex.peek()>=K)){
                flipIndex.poll();
            }
            /**
             0 (even number) -> flip  twice (even number) -> 0 (need to be fliped)
             -> flip  once (odd number)   -> 1 (don't need)

             1 (odd number)  -> flip  once (odd number)   -> 0 (need to be fliped)
             -> flip  twice (even number) -> 1 (don't need)
             Summary:
             In a window,  if A[i] is a even number with even times fliped, it need to be fliped again.
             On other hand,if A[i] is a odd number with odd times fliped, it need to be fliped again.
             */

            if(A[i]%2 == flipIndex.size()%2){
                if(i+K-1>=A.length){
                    return -1;
                }
                flipIndex.offer(i);
                ans++;
            }
        }
        return ans;

    }
}
