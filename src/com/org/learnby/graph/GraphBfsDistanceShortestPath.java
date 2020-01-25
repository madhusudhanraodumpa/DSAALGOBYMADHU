package com.org.learnby.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBfsDistanceShortestPath {
    public static void main(String args[]){
        Graph<Integer> graph=new Graph<>(7);
        graph.addEdge(0,1,true);
        graph.addEdge(1,2,true);
        graph.addEdge(0,4,true);
        graph.addEdge(2,4,true);
        graph.addEdge(3,2,true);
        graph.addEdge(4,3,true);
        graph.addEdge(3,5,true);
        bfsDistanceShortestPath(graph,0,6,5);

    }

    private static void bfsDistanceShortestPath(Graph<Integer> graph, int src, int vertices,int dest) {
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
            System.out.print(node);
            queue.poll();
            List<Integer> neighbors=graph.adjList.get(node);

            for (Integer element : neighbors) {
                if (visited[element] == false) {
                    queue.add(element);
                    visited[element] = true;
                    distance[element]=distance[node]+1;
                    parentNode[element]=node;
                }
            }
        }
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
