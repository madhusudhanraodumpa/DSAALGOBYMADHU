package com.org.prepartion.dynamicprograming;


//https://www.youtube.com/watch?v=0kfCd3N95uQ

//https://www.youtube.com/watch?v=xN5pTiUinHw&list=PLTAk1jG45iLPWI9pRpYtDwRAlVK7Ya7gG&index=2

/*https://www.youtube.com/watch?v=D7AFvtnDeMU
 https://www.youtube.com/watch?v=kMK148J9qEE*/

public class MatrixChainMultiplication {
    public static void main(String args[]){
        int a[]={1, 2, 3, 4, 3};
        System.out.println(minCostDP1(a,a.length));

    }
    public static int minCostDP1(int a[],int n){
        int m[][] =new int[n][n];
        int s[][] =  new int[n][n];
        for(int len=2 ;len<n;len++){
            for(int i=1;i<n-len+1;i++){
                int j=i+len-1;
                if(i==j) {
                    m[i][j] = 0;
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost = m[i][k]+m[k+1][j]+(a[i-1]*a[k]*a[j]);
                    if(m[i][j]>cost){
                        m[i][j]=cost;
                        s[i][j] = k;
                    }

                }
            }
        }
        return m[1][n-1];
    }

}
