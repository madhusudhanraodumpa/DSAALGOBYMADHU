package com.org.learnby.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsBipartiteGraph {
    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(4);
        graph.addEdge(1,2,true);
        graph.addEdge(1,3,true);
        graph.addEdge(2,4,true);
        graph.addEdge(3,4,true);
       // graph.addEdge(1,4,true);
        IsBipartiteGraph b = new IsBipartiteGraph();
        System.out.println(b.isBipartite(graph, 1));
    }

    private boolean isBipartite(Graph<Integer> graph, int src) {

        int[] color = new int[5];
        Arrays.fill(color, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 0;
        boolean isBipartite = true;
        while (!queue.isEmpty() && isBipartite) {
            Integer node = queue.peek();
            queue.poll();
            List<Integer> neighbors = graph.adjList.get(node);
            if (neighbors != null) {
                for (Integer element : neighbors) {
                    if (color[element] == -1) {
                        color[element] = 1 - color[node];
                        queue.add(element);
                    } else if (color[element] == color[node]) {
                        isBipartite = false;
                        break;
                    }
                }
            }
        }
        return isBipartite;

    }

}
