package com.org.prep.hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSuduko {
    public static void main(String[] args){

        String[][] board={{".",".","4",".",".",".","6","3","."},{".",".",".",".",".",".",".",".","."},{"5",".",".",".",".",".",".","9","."},{".",".",".","5","6",".",".",".","."},{"4",".","3",".",".",".",".",".","1"},{".",".",".","7",".",".",".",".","."},{".",".",".","5",".",".",".",".","."},{".",".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".",".","."}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(String[][] board) {

        int n=board.length;
        int m=board[0].length;

        Set[] rowSet=new Set[n];
        Set[] colSet= new Set[m];
        Set[] indexSet=new Set[9];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j].equals(".")){
                    continue;
                }

                int num=Integer.parseInt(board[i][j]);
                if(rowSet[i] !=null && rowSet[i].contains(num)){
                    return false;
                }else{
                    if(rowSet[i]==null){
                        rowSet[i]=new HashSet();
                    }
                    rowSet[i].add(num);
                }

                if(colSet[j]!=null && colSet[j].contains(num)){
                    return false;
                }else{
                    if(colSet[j]==null){
                        colSet[j]=new HashSet<>();
                    }
                    colSet[j].add(num);
                }

                int index= ((i/3)*3)+(j/3);
                if(indexSet[index] !=null && indexSet[index].contains(num)){
                    return false;
                }else{
                    if(indexSet[index]==null){
                        indexSet[index]=new HashSet<>();
                    }
                    indexSet[index].add(num);
                }


            }
        }
        return true;

    }

}
