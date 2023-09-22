package com.org.prep.array;
import java.util.*;

public class SubarrayGivenSum {
    public static void main(String args[]){
        int a[]={23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6};
        solve(a,62);
    }

    public static int[] solve(int[] A, int B) {
        int n=A.length;
        int p1=0;
        int p2=0;
        int sum=0;

        //  Arrays.sort(A);
        while(p2<n){
            sum=sum+A[p2];
            if(sum==B){
                int[] ans=new int[2];
                ans[0]=A[p1];
                ans[1]=A[p2];
                return ans;
            }
            else if(sum<B){
                p2++;
            }else{
                while (sum>B && p1<n) {
                    sum = sum - A[p1];
                    p1++;
                }
                if(sum==B){
                    int[] ans=new int[p2-p1+1];
                    int k=p1;
                    for(int i=0;i<ans.length;i++){
                        ans[i]=A[k++];
                    }
                    return ans;
                }
                p2++;
            }
        }

        int[] ans1={-1};
        return ans1;
    }
}
