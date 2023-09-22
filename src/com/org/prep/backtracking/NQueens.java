package com.org.prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public  static int val=0;
    public static void main(String args[]){
        NQueens nQueens=new NQueens();
        nQueens.totalNQueens(4);
        System.out.println(val);

    }
    public int totalNQueens(int n) {
        char[][] q=new char[n][n];
        Arrays.stream(q).forEach(a -> Arrays.fill(a, '.'));
        List<List<String>> res=new ArrayList<>();

        solveNQueens(n,0,q,res);
        return val;
    }


    public void solveNQueens(int n, int row, char[][] q,List<List<String>> res){
        if(row==n){
            res.add(construct(q));
            val++;
            return;
        }
        for(int col=0;col<n;col++){

            if(check(row,col,q,n)){
                q[row][col]='Q';
                solveNQueens(n,row+1,q,res);
                q[row][col]='.';
            }
        }
    }
    public boolean check(int row,int col,char[][] q,int n){
        int j=col;
        for(int i=row;i>=0;i--){
            if('Q'==q[i][j]){
                return false;
            }
        }

        int i=row;
        j=col;
        while(i>=0 && j>=0){
            if('Q'==q[i][j]){
                return false;
            }
            i--;
            j--;
        }

        i=row;
        j=col;

        while(i>=0 && j<n){
            if('Q'==q[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
