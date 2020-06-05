package com.org.learnby.recursion;

import java.util.HashMap;
import java.util.Map;

public class NQueenProblem {
    public static final int n = 6;
    public static int count = 0;
    public static Position[] postions = new Position[n];
    public static   Map<Integer,Boolean> checkRightDiagonals=new HashMap<>();
    public static Map<Integer,Boolean> checkLeftDiagonals=new HashMap<>();

    public static Map<Integer,Boolean> checkColumns=new HashMap<>();


    public static void main(String args[]) {
        NQueenProblem s = new NQueenProblem();
        int[][] queenBoard = new int[n][n];
        s.solveNQueen1(n, 0, queenBoard);
        System.out.println(count);
    }

    private boolean solveNQueen1(int n, int row, int[][] queenBoard) {
        //base case
        if (row == n) {
                count++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(queenBoard[i][j] == 1 ? "Q " : queenBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("############################");
            return false;
        }

        //Recursive case

        for (int k = 0; k < n; k++) {

            if (isSafePostion(n,row, k, queenBoard)) {
                queenBoard[row][k] = 1;

                boolean iscanPlaceQueen = solveNQueen1(n, row + 1, queenBoard);
                if (iscanPlaceQueen) {
                    return true;
                }
                manageColumns(row,k,false);
                queenBoard[row][k] = 0;
            }


        }


        return false;
    }

    private boolean isSafePostion(Integer n,int row, int col, int[][] queenBoard) {
        if(!checkColumns.getOrDefault(col,false) && !(checkRightDiagonals.getOrDefault(row+col,false)) && !(checkLeftDiagonals.getOrDefault(row-col,false))){
            manageColumns(row, col,true);
            return true;
        }
        return false;
    }

    private void manageColumns(int row, int col,boolean flag) {
        checkColumns.put(col,flag);
        checkRightDiagonals.put(row+col,flag);
        checkLeftDiagonals.put(row-col,flag);
    }


    class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    private boolean solveNQueen(int n, int row, int[][] queenBoard) {
        if (n == row) {
            count++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(queenBoard[i][j] == 1 ? "Q " : queenBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("############################");
            return false;
        }


        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;
            for (int queen = 0; queen < row; queen++) {

                Position p = postions[queen];
                if (p.col == col || (p.col + p.row == col + row) || (p.row - p.col == row - col)) {
                    foundSafe = false;
                    break;
                }

            }
            if (foundSafe) {
                queenBoard[row][col] = 1;
                postions[row] = new Position(row, col);
                if (solveNQueen(n, row + 1, queenBoard)) {
                    return true;
                }
                queenBoard[row][col] = 0;
            }
        }
        return false;

    }


}
