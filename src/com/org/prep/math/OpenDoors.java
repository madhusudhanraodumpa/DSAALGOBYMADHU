package com.org.prep.math;
import java.util.*;

public class OpenDoors {
    public static void main(String[] args){
        solve(6);
    }
    public static int solve(int A) {
        int count=0;
        boolean[] isOpen=isOpenDoors(A);
        for(int i=1;i<=A;i++){
            if(isOpen[i]){
                count++;
            }
        }
        return count;
    }

    public static boolean[] isOpenDoors(int n){
        boolean[] a=new boolean[n+1];
        Arrays.fill(a,true);
        a[0]=false;
        a[1]=false;


        for(int i=2;i<=n;i++){

                for(int j=i;j<=n;j=j+i){

                    a[j]=!a[j];
                }


        }
        return a;

    }
}
