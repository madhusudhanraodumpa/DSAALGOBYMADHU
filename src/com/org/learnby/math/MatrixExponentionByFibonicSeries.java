package com.org.learnby.math;

public class MatrixExponentionByFibonicSeries {
    public static int mod=1000000007;
    public static void main(String args[]){
        System.out.println(findNthTerm(100));
    }

    public static int findNthTerm(int n){
        int fn[]={0,1,1};

            if(n==0 || n==1 || n==2){
                return fn[n];
            }
           int[][] f={{0,1,0},{0,0,1},{1,1,1}};
          int[][] f1= power(f,n-2);
            int res=0;
            for(int i=0;i<=2;i++){
                res=(res%mod+(f1[2][i]*fn[i])%mod)%mod;
            }

           return res;

    }

    private static int[][]  power(int[][] f, int n) {
        if(n==1){
            return f;
        }
        if((n&1) == 1){
           return  multiply(f,power(f,n-1));
        }else{
           int[][] f1= power(f,n/2);
           return  multiply(f1,f1);
        }
    }

    private static int[][] multiply(int[][] f1, int[][] f2) {
        int mul[][] = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mul[i][j] = 0;
                for (int k = 0; k < 3; k++)
                    mul[i][j] =((mul[i][j])%mod+ (f1[i][k]
                            * f2[k][j])%mod)%mod;
            }
        }
        return mul;
    }


}
