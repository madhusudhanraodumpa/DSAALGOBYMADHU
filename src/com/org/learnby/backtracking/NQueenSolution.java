package com.org.learnby.backtracking;

import java.util.BitSet;

public class NQueenSolution {
    public static int count=0;
    static boolean[] c1 = new boolean[10];
    static boolean[] d1 = new boolean[10];
    static boolean[] d2 = new boolean[10];

    public static void main(String args[]){
        String[][] board=new String[10][10];


        int n=9;
        int i=0;
        solveNQueen(board,i,n);
        System.out.println("Total possible ways is "+count);

    }

    static boolean solveNQueen(String[][] board,int i,int n){
        if(i==n){
            for(int row=0;row<n;row++){
                for(int col=0;col<n;col++){
                    System.out.print((board[row][col]==null)?"_ ":board[row][col]+" ");
                }
                System.out.println();
            }
            System.out.println();

            count++;
            return false;
        }
        for(int j=0;j<n;j++){
           // if(check(board,i,j,n)){
            if(!c1[j] && !d1[i-j+n-1] && !d2[i+j]){
                board[i][j]="Q";
                c1[j] = d1[i-j+n-1] = d2[i+j]=true;

                boolean isplaced=solveNQueen(board,i+1,n);
                if(isplaced){
                    return true;
                }
                board[i][j]=null;

                c1[j] = d1[i-j+n-1] = d2[i+j]=false;
            }

        }
        return false;
    }

    private static boolean check(String[][] board, int i, int j, int n) {
        for(int row=0;row<i;row++){
            if(board[row][j]=="Q"){
                return false;
            }
        }

        int x=i;
        int y=j;

        while(x>=0 && y>=0){
            if(board[x][y]=="Q"){
                return false;
            }
            x--;
            y--;
        }

         x=i;
         y=j;

        while(x>=0 && y<n){
            if(board[x][y]=="Q"){
                return false;
            }
            x--;
            y++;
        }

        return true;
    }

}
