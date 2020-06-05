package com.org.learnby.recursion;

public class SudokoProblemBacktracking {



    public static void main(String args[]){

      //  int[][] sudukoBoard={{0,2,3,0},{0,0,0,1},{0,1,0,0},{2,4,1,0}};
        int[][] sudukoBoard={{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},{8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
        int[][] sudukoBoard1={{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},{8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};

        int length=9;
        boolean flag=solveSuduko(sudukoBoard,length);
        boolean flag1=solve(sudukoBoard1,length,0,0);

        if(flag){
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    System.out.print(sudukoBoard[i][j]+" ");
                }
                System.out.println();
            }

        }

        System.out.println("########################################");

        if(flag1){
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    System.out.print(sudukoBoard1[i][j]+" ");
                }
                System.out.println();
            }

        }

    }

    private static boolean solve(int[][] sudukoBoard, int length,int row,int col){
        if(row==length){
            return true;
        }
        if(col==length){
            return solve(sudukoBoard,length,row+1,0);
        }
        if(sudukoBoard[row][col]!=0){
            return solve(sudukoBoard,length,row,col+1);
        }

        for(int num=1;num<=length;num++){
            if(isSafePlace(num,row,col,sudukoBoard,length)){
                sudukoBoard[row][col]=num;
                boolean isSolved=solve(sudukoBoard,length,row,col+1);
                if(isSolved){
                    return true;
                }else{
                    sudukoBoard[row][col]=0;
                }

            }
        }


    return false;
    }

    private static boolean solveSuduko(int[][] sudukoBoard, int length) {

        int row=-1;
        int col=-1;
        boolean isEmpty=true;

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(sudukoBoard[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        if(isEmpty) {
            return true;
        }

        for(int num=1;num<=length;num++){

            if(isSafePlace(num,row,col,sudukoBoard,length)){
                sudukoBoard[row][col]=num;
                if(solveSuduko(sudukoBoard,length)){
                    return true;
                }else{
                    sudukoBoard[row][col]=0;
                }
            }
        }
        return false;

    }


    public static boolean isSafePlace(int num,int row,int col,int[][] sudukoBoard,int length) {

        //checking all the cells in the row
        for(int i=0;i<length;i++){
            if(sudukoBoard[row][i] == num){
                return false;
            }
        }

        //checkng all the cells in that columns
        for(int j=0;j<length;j++){
            if(sudukoBoard[j][col] == num){
                return false;
            }
        }


        //Checking small box
        int sqrt=(int)Math.sqrt(length);

        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;

        for(int r=rowStart;r<rowStart+sqrt;r++){
            for(int c=colStart;c<colStart+sqrt;c++){
                if(sudukoBoard[r][c] == num)
                    return false;
            }
        }

        return true;


    }

}




