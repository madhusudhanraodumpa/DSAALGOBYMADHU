package com.org.learnby.graph;

import java.util.*;

public class UnDirectedGraphCyclicBFS<T> {

    public static void main(String args[]) {

        Graph<Integer> graph = new Graph<>(6);
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(4, 3, true);
        graph.addEdge(3,5,true);
        graph.addEdge(2,4,true);
        UnDirectedGraphCyclicBFS<Integer> u = new UnDirectedGraphCyclicBFS<>();
        System.out.println(u.isCyclicBFS(graph, 0));
        System.out.println(u.isCyclicBFS2ndWay(graph,0));


    }
// checking cyclic for undirected graph using only visted set and queue.
    public boolean isCyclicBFS(Graph<T> graph, T src) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);
        while (!queue.isEmpty()) {
            T node = queue.peek();
            queue.poll();
            System.out.print(node + " ");

            List<T> negihbors = graph.adjList.get(node);
            if (negihbors != null) {
                for (T negihbor : negihbors) {
                    if (visited.contains(negihbor) && queue.contains(negihbor)) {
                        return true;
                    } else if (!visited.contains(negihbor)) {
                        queue.add(negihbor);
                        visited.add(negihbor);
                    }

                }
            }
        }
        return false;
    }


    public boolean isCyclicBFS2ndWay(Graph<T> graph, T src) {
        Set<T> visited = new HashSet<>();
        Map<T,T> parent=new HashMap<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(src);
        parent.put(src,src);
        visited.add(src);
        while (!queue.isEmpty()) {
            T node = queue.peek();
            queue.poll();
            System.out.print(node + " ");

            List<T> negihbors = graph.adjList.get(node);
            if (negihbors != null) {
                for (T negihbor : negihbors) {
                    if (visited.contains(negihbor) && parent.get(node)!=negihbor) {
                        return true;
                    } else if (!visited.contains(negihbor)) {
                        queue.add(negihbor);
                        parent.put(negihbor,node);
                        visited.add(negihbor);
                    }
                }
            }
        }
        return false;
    }
}


