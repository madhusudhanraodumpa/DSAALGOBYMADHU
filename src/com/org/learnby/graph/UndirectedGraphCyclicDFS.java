package com.org.learnby.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraphCyclicDFS<T> {

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(6);
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(2, 3, true);
       // graph.addEdge(4, 3, true);
        graph.addEdge(3, 5, true);
      //  graph.addEdge(2, 4, true);
        UndirectedGraphCyclicDFS<Integer> ud = new UndirectedGraphCyclicDFS<>();
        System.out.println(ud.isCyclicDFS(graph, 0));

    }

    public boolean isCyclicDFS(Graph<T> graph, T src) {

        Set<T> visited = new HashSet<>();
        // Here dfs is started from 0 but we can try for all the nodes in graph if we not started from any source.
        return dfsUtil(graph, visited, src, src);
    }

    public boolean dfsUtil(Graph<T> graph, Set<T> visited, T src, T parent) {
        visited.add(src);
        List<T> negihbors = graph.adjList.get(src);
        if (negihbors != null) {
            for (T element : negihbors) {
                if (!visited.contains(element)) {
                    boolean cyclicDetected = dfsUtil(graph, visited, element, src);
                    if (cyclicDetected) {
                        return true;
                    }


                } else if (element != parent) {
                    return true;
                }


            }


        }

        return false;

    }

}
