package com.org.learnby.graph;

import java.util.*;

public class TooppologicalSortUsingDFS<T> {
    public static void main(String args[]) {
        TooppologicalSortUsingDFS<Integer> t = new TooppologicalSortUsingDFS();
        Graph<Integer> graph = new Graph<>(7);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(5, 6, false);
        graph.addEdge(6, 3, false);
        graph.addEdge(3, 8, false);
        graph.addEdge(8, 11, false);
        t.topologicalSortDfs(graph);
    }

    private void topologicalSortDfs(Graph<T> graph) {
        Deque<T> stack = new ArrayDeque<>();
        Set<T> set = new HashSet<>();
        for (Map.Entry<T, List<T>> entry : graph.adjList.entrySet()) {
            if (!set.contains(entry.getKey())) {
                dfsTopSort(entry.getKey(), graph, set, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.removeFirst() + " ");
        }
    }

    private void dfsTopSort(T key, Graph<T> graph, Set<T> set, Deque<T> stack) {
        List<T> list = graph.adjList.get(key);
        set.add(key);
        if (list != null) {
            for (T element : list) {
                if (!set.contains(element)) {
                    dfsTopSort(element, graph, set, stack);
                }
            }
        }
        stack.offerFirst(key);
    }
}
