package com.org.prep.array;

public class EvenLenSubarrays {

    public String solve(int[] A) {
        int n=A.length;
        if(n%2!=0 || A[0]%2!=0 || A[n-1]%2!=0)
            return "NO";

        else
            return "YES";
    }
}
