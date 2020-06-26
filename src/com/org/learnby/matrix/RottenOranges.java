package com.org.learnby.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String args[]){
        int[][] a={{0,2}};
        System.out.println(orangesRotting(a));
    }
    public static int orangesRotting(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Queue<Pixel> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pixel(i,j));
                }
            }
        }
        q.add(new Pixel(-1,-1));
        while(!q.isEmpty()){

            while(!isDelimaterPixel(q.peek())){
                Pixel p=q.remove();
                if(isFreshOrange(grid,p.getX(),p.getY()-1)){
                    grid[p.getX()][p.getY()-1]=2;
                    q.add(new Pixel(p.getX(),p.getY()-1));

                }
                if(isFreshOrange(grid,p.getX(),p.getY()+1)){
                    grid[p.getX()][p.getY()+1]=2;
                    q.add(new Pixel(p.getX(),p.getY()+1));

                }
                if(isFreshOrange(grid,p.getX()-1,p.getY())){
                    grid[p.getX()-1][p.getY()]=2;
                    q.add(new Pixel(p.getX()-1,p.getY()));

                }
                if(isFreshOrange(grid,p.getX()+1,p.getY())){
                    grid[p.getX()+1][p.getY()]=2;
                    q.add(new Pixel(p.getX()+1,p.getY()));

                }
            }
            q.remove();
            if(!q.isEmpty()) {
                count++;
                q.add(new Pixel(-1, -1));
            }

        }
        return isAnyFrshOrangeLeft(grid)?-1:count;
    }

    private static boolean isAnyFrshOrangeLeft(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return true;
            }
        }
        return false;
    }

    private static boolean isFreshOrange(int[][] grid, int x, int y) {
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1;
    }

    private static boolean isDelimaterPixel(Pixel p) {
        return p.getX()==-1 && p.getY()==-1?true:false;
    }
}
class Pixel{
    int x;
    int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
