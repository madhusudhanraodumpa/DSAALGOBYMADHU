package com.org.prep.array;

public class PairsGivenSumII {
    public static void main(String args[]){
        int a[]={1, 2, 6, 6, 7, 9, 9};
        solve(a,13);
    }
    public static int solve(int[] A, int B) {
        int n=A.length;
        int p1=0;
        int p2=n-1;
        int count=0;
        int sum=0;
        while(p1<p2){
            sum=A[p1]+A[p2];
            if(sum==B){
                int val1=A[p1];
                int x=p1;
                while((p1<p2) && val1==A[p1]){
                    p1++;
                }
                int val2=A[p2];
                int y=p2;
                while((p2>=p1) &&  val2==A[p2]){
                    p2--;
                }

                if (val1 == val2)
                {
                    int temp = p1 - x + y - p2 - 1;
                    count += (temp * (temp + 1)) / 2;
                }
                else
                    count += (p1 - x) * (y - p2);



            }else if(sum<B){
                p1++;
            }else{
                p2--;
            }


        }
        return count;
    }
}
