package com.org.prep.dp;

public class MinimumSqures {
    public static void  main(String args[]){
        MinimumSqures m=new MinimumSqures();
        m.countMinSquares(13);
    }


    public int countMinSquares(int A) {
        int[] sqr=new int[A+1];

        sqr[0]=0;
        sqr[1]=1;

        for(int i=2;i<=A;i++){
            int ans=Integer.MAX_VALUE;

            for(int j=1;j*j<=i;j++){

                ans=Math.min(ans,sqr[i-(j*j)]);
            }
            sqr[i]=ans+1;



        }

        return sqr[A];



    }
}
