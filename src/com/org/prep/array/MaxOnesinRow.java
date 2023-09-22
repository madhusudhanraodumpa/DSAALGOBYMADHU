package com.org.prep.array;

public class MaxOnesinRow {
    public static void main(String args[]){
        int[][] a={{0,0,0},{0, 0, 0},{0,0,0},{0,0,0}};
        System.out.println(solve1(a));
        double d1 = 5f;
         double d2 = 5.0;
         float f1 = 5f;
        float f2 = 5f;
    }

    public static int solve1(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int i=0;
        int j=m-1;
       /* while(j>=0 && a[i][j]==1){
            j--;
        }*/
        int row =0;
        for (i=0;i<n;i++){
            while (j>=0 && a[i][j]==1){
                row = i;
                j--;
            }
        }
        return j==m-1?-1:row;
    }

    public static int solve(int[][] A) {
        /**  int n=A.length;
         int m=A[0].length;
         int rowIndex=-1;

         int maxOnes=Integer.MIN_VALUE;

         for(int i=0;i<n;i++){
         int count=0;
         for(int j=0;j<m;j++){

         if(A[i][j]==1){
         count++;
         }
         if(count>maxOnes){
         maxOnes=count;
         rowIndex=i;
         }

         }
         }
         return rowIndex;
         **/

        int n=A.length;
        int m=A[0].length;
        int rowIndex=-1;

        int maxOnes=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int columnIndex=binarySearch(A[i]);
            if(m-columnIndex>maxOnes){
                maxOnes=m-columnIndex;
                rowIndex=i;
            }

        }

        return rowIndex;

    }

    public static int binarySearch(int a[]){

        int serachElement=0;
        int s=0;
        int e=a.length-1;

        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(a[mid]==serachElement){
                ans=mid;
                //+

                //break;
            }else if(a[mid]>serachElement){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;


    }
}
