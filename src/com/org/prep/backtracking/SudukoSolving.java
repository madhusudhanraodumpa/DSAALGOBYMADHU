package com.org.prep.backtracking;

import java.util.Arrays;

public class SudukoSolving {

    public static void main(String[] args){
        SudukoSolving s=new SudukoSolving();
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] board1=new char[9][9];

        for (int i = 0; i < 9; i++) {
            board1[i] = Arrays.copyOf(board[i], board[i].length);
        }
        solveSudoku(board1,0,board);
        System.out.println();
    }

    public static void solveSudoku(char[][] board,int index,char[][] board1){

        if(index==81) {
            for (int i = 0; i < 9; i++) {
                board1[i] = Arrays.copyOf(board[i], board[i].length);
            }
            return;

        }

        int row=index/9;
        int col=index%9;

        if(board[row][col]!='.'){
            solveSudoku(board,index+1,board1);
        }else{
            for(char c = '1'; c <= '9'; c++){
                if(isValid(board,row,col,c)){
                    board[row][col]=c;
                    solveSudoku(board,index+1,board1);
                    board[row][col]='.';

                }
            }



        }





    }
    public static boolean isValid(char[][] board,int row,int col,char val){

        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==val){
                return false;
            }
        }
        int x=row-(row%3);
        int y=col-(col%3);


        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }

        return true;

    }
}
