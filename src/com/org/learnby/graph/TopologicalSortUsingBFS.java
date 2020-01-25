package com.org.learnby.graph;

import java.util.*;

public class TopologicalSortUsingBFS<T> {
    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(7);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(5, 6, false);
        graph.addEdge(6, 3, false);
        graph.addEdge(3, 8, false);
        graph.addEdge(8, 11, false);
        TopologicalSortUsingBFS<Integer> t=new TopologicalSortUsingBFS<>();
        t.topologicalSortUsingBfs(graph);
        //topologicalSortUsingBfs(graph);
    }
    public void topologicalSortUsingBfs(Graph<T> graph){
        Map<T,Integer> indgree=new HashMap<>();
        Set<T> visited=new HashSet<>();
        Queue<T> queue=new LinkedList<>();

        for(Map.Entry<T, List<T>> entry:graph.adjList.entrySet()){
            indgree.put(entry.getKey(),0);
        }

        for(Map.Entry<T, List<T>> entry:graph.adjList.entrySet()) {
            if (graph.adjList.get(entry.getKey()) != null) {
                for (T element : graph.adjList.get(entry.getKey())) {
                    int dggree = indgree.get(element) != null ? indgree.get(element) : 0;
                    indgree.put(element, ++dggree);
                }
            }
        }

        for(Map.Entry<T,Integer> entry:indgree.entrySet()){
            if(indgree.get(entry.getKey())==0){
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()){
            T element= queue.peek();
            queue.poll();
            System.out.print(element+" ");

            List<T> list=graph.adjList.get(element);
            if(list!=null) {
                for (T neighbor : list) {
                    int d = indgree.get(neighbor);
                    indgree.put(neighbor, --d);
                    if (indgree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }

                }
            }




        }


       /* for (Map.Entry<T,Integer> entry:indgree.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }*/





    }
}
