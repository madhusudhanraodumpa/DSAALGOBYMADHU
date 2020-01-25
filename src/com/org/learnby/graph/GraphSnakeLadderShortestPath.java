package com.org.learnby.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSnakeLadderShortestPath {

    public static void main(String args[]){
        int[] board=new int[42];//36+6 dices
        board[2]=13;
        board[5]=2;
        board[9]=18;
        board[18]=11;
        board[17]=-13;
        board[20]=-14;
        board[24]=-8;
        board[25]=-10;
        board[32]=-2;
        board[34]=-22;
        Graph<Integer> graph=new Graph<>(42);
        for(int u=0;u<36;u++){
            for(int dice=1;dice<=6;dice++){
                        int v=u+dice+board[u+dice];
                        if(v<=36) {
                            graph.addEdge(u, v, false);
                        }

            }
        }
        bfsDistanceShortestSnakeAndLadder(graph,0,42,36);

    }

    private static void bfsDistanceShortestSnakeAndLadder(Graph<Integer> graph, int src, int vertices,int dest) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[vertices];
        int[] distance=new int[vertices];
        int[] parentNode=new int[vertices];
        for(int i=0;i<vertices;i++){
            parentNode[i]=-1;
        }
        queue.add(src);
        visited[src]=true;
        while (!queue.isEmpty()){
            Integer node=queue.peek();
            System.out.print(node+" ");
            queue.poll();
            List<Integer> neighbors=graph.adjList.get(node);
        if(neighbors!=null){
            for (Integer element : neighbors) {
                if (visited[element] == false) {
                    queue.add(element);
                    visited[element] = true;
                    distance[element]=distance[node]+1;
                    parentNode[element]=node;
                }
            }
        }}
        System.out.println();
        for(int i=0;i<vertices;i++){
            System.out.println(i+" node having distance "+distance[i]);
        }
        System.out.println("Shortest distance is "+distance[dest]);
        int temp=dest;
        while(temp!=-1){
            System.out.print(temp+"<---");
            temp=parentNode[temp];
        }
    }
}
