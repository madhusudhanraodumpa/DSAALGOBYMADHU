package com.org.prep.array;

public class SetMatrixZero {

    public static void main(String args[]){
        int[][] a={{1,1,0,1},{0,1,1,1},{1,0,1,1},{1,1,1,1}};

        setZeroes(a);

    }

    public static void setZeroes(int[][] A) {

        //  boolean col=true;
        int n=A.length;
        int m=A[0].length;
        int col=1;
        int row=1;

      for(int i=0;i<n;i++){
          if(A[i][0]==0){
              col=0;
              break;
          }
      }
      for(int j=0;j<m;j++){
          if(A[0][j]==0){
              row=0;
              break;
          }
      }

      for(int i=1;i<n;i++){
          for(int j=1;j<m;j++){
              if(A[i][j]==0){
                  A[0][j]=0;
                  A[i][0]=0;
              }
          }
      }

      /**
      for(int j=1;j<m;j++){

          if(A[0][j]==0){
              for(int i=1;i<n;i++){
                  A[i][j]=0;
              }
          }

      }

      for(int i=1;i<n;i++){
          if(A[i][0]==0){
              for(int j=1;j<m;j++){
                  A[i][j]=0;
              }
          }
      }
       **/

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){

                if(A[i][0]==0||A[0][j]==0){
                    A[i][j]=0;
                }


            }
        }

      if(row==0){

          for(int j=0;j<m;j++){
              A[0][j]=0;
          }
      }

      if(col==0){
          for(int i=0;i<n;i++){
              A[i][0]=0;
          }
      }



    }
}
