package com.org.prep.array;

import java.util.*;

public class SumofSubmatriceEqualsTraget {
    public static void main(String args[]){
        int a[][]={{0,1,0},{1,1,1},{0,1,0}};
        System.out.println(numSubmatrixSumTarget(a,0));
    }


    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;

       // calculatePrefixSumMatrix(matrix);

       // ans=maxSumSubMatrix(matrix,target);
        ans=maxSumSubMatrix1(matrix,target);

        return ans;
    }

    public static void calculatePrefixSumMatrix(int[][] a){
        int n=a.length;
        int m=a[0].length;
        int[][] x=new int[n][m];

        /*for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum=sum+a[i][j];
                a[i][j]=sum;
            }
        }*/

        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+a[i][j];
                a[i][j]=sum;
            }
        }


    }

    public static int maxSumSubMatrix1(int[][] a,int val){


        int n=a.length;
        int m=a[0].length;
        int sum=0;
        int x[]=new int[m];
        for(int rowStart=0;rowStart<n;rowStart++){
            Arrays.fill(x,0);
            for (int rowEnd=rowStart;rowEnd<n;rowEnd++){



                    for(int k=0;k<m;k++){
                        x[k]= x[k]+a[rowEnd][k];
                    }

                sum=sum+subarraySum(x,val);


            }
        }
        return sum;
    }

    public static int maxSumSubMatrix(int[][] a,int val){


        int n=a.length;
        int m=a[0].length;
        int sum=0;
        for(int rowStart=0;rowStart<n;rowStart++){
            for (int rowEnd=rowStart;rowEnd<n;rowEnd++){

                int x[]=new int[m];
                if(rowStart==0){
                    x=a[rowEnd];
                }else{
                    for(int k=0;k<m;k++){
                        x[k]= a[rowEnd][k]-a[rowStart-1][k];
                    }
                }
                sum=sum+subarraySum(x,val);


            }
        }
        return sum;
    }

    public static int subarraySum(int[] a, int k) {
        int n=a.length;
        Map<Integer,Integer> m=new HashMap<>();
        int count=0;
        //m.put(0,1);
        int preSum=0;
        for(int i=0;i<n;i++){
            preSum=preSum+a[i];
            if(preSum==k){
                count++;
            }
            if(m.containsKey(preSum-k)){
                count=m.get(preSum-k)+count;
            }
            m.put(preSum,m.getOrDefault(preSum,0)+1);

        }
        return count;
    }
}
