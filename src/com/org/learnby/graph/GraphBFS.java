package com.org.learnby.graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class GraphBFS {
    public static void main(String args[]){
        Graph<Integer> graph=new Graph<>(7);
        graph.addEdge(0,1,true);
        graph.addEdge(1,2,true);
        graph.addEdge(0,4,true);
        graph.addEdge(2,4,true);
        graph.addEdge(3,2,true);
        graph.addEdge(4,3,true);
        graph.addEdge(3,5,true);
        BfsTraversalOfGraph(graph,0,7);

    }

    private static void BfsTraversalOfGraph(Graph<Integer> graph,Integer src,Integer vertices) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[vertices];
        queue.add(src);
        visited[src]=true;
        while (!queue.isEmpty()){
            Integer node=queue.peek();
            System.out.print(node);
            queue.poll();
            List<Integer> neighbors=graph.adjList.get(node);
         //  neighbors.stream().filter(e -> visited[e]).map(e -> queue.add(e)).map(e -> (visited[e] = true));
            //if(neighbors!=null) {
                for (Integer element : neighbors) {
                    if (visited[element] == false) {
                        queue.add(element);
                        visited[element] = true;
                    }
                }
            //}
        }
    }
}
