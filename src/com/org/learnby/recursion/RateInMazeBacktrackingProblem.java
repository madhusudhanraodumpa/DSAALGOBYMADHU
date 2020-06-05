package com.org.learnby.recursion;

public class RateInMazeBacktrackingProblem {
    public static int N=4;
    public static int pathCount=0;

    public static void main(String args[]){
        int maze[][]={{1,0,0,0},
                    {1,1,1,0},
                    {1,0,1,1},
                    {0,0,1,1}};
        int[][] finalPath = new int[4][4];
        boolean pathFound = rateMaze(maze,0,0,finalPath);
        if(pathFound){
           System.out.println("Total path are found is : "+pathCount);

        }else{
            System.out.println("There is no path found.");
        }
    }

    //Checking all path paths : Constarints right and down direction
    private static boolean rateMaze(int[][] maze, int i, int j, int[][] finalPath) {
        if ((i == N - 1 && j == N - 1 && maze[i][j]==1)) {
            finalPath[i][j] = 1;
            for (int x=0;x<N;x++){
                for(int y=0; y<N;y++){
                    System.out.print(finalPath[x][y]+",");
                }
                System.out.println();
            }
            pathCount++;
            System.out.println("###############");

            return false;
        }

        if(i>=N || j>=N){
            return false;
        }
        if(maze[i][j]== 0){
            return false;
        }
        finalPath[i][j]=1;
        boolean rightSucess=rateMaze(maze,i,j+1,finalPath);
        boolean downSucess=rateMaze(maze,i+1,j,finalPath);
        finalPath[i][j]=0;

        if(rightSucess || downSucess){
            return true;
        }
        return false;
    }
    //checking only one path :constrainst are right and down direction only

    private static boolean findPath(int[][] maze, int i, int j, int[][] finalPath) {
        if ((i == N - 1 && j == N - 1) && maze[i][j] == 1) {
            finalPath[i][j] = 1;

            for (int x=0;x<N;x++){
                for(int y=0; y<N;y++){
                    System.out.print(finalPath[x][y]+",");
                }
                System.out.println();
            }
            return true;
        }

        if (i >= 0 && i < N && j >= 0 && j < N && maze[i][j]==1) {
            finalPath[i][j] = 1;
            if(findPath(maze, i + 1, j, finalPath)){
                return true;
            }
            if(findPath(maze, i, j + 1, finalPath)){
                return true;
            }
            finalPath[i][j] = 0;
        }
        return false;
    }


}
