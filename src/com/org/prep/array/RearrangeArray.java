package com.org.prep.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArray {
    public static void main(String args[]){
        List<Integer> list= Arrays.asList(1, 2, 7, 0, 9, 3, 6, 8, 5, 4);
        arrange(list);

    }
    public static void arrange(List<Integer> A) {

        int n=A.size();

        for(int i=0;i<n;i++){
            A.set(i,A.get(i)*n);
        }

        for(int i=0;i<n;i++){
            int index=A.get(i)/n;
            int val=A.get(index)/n;
            A.set(i,A.get(i)+val);
        }

        for(int i=0;i<n;i++){
            A.set(i,A.get(i)%n);
        }

    }
}
