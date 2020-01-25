package com.org.learnby.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphDFS {
    public static void main(String args[]){
        Graph<Integer> graph=new Graph<>(7);
        graph.addEdge(0,1,true);
        graph.addEdge(1,2,true);
        graph.addEdge(0,4,true);
        graph.addEdge(2,4,true);
        graph.addEdge(3,2,true);
        graph.addEdge(4,3,true);
        graph.addEdge(3,5,true);
      //  DfsTraversalOfGraph(graph,0,7);
        dfs(0,graph);

    }
    public static void dfs(int src,Graph<Integer> graph){
        Map<Integer, Boolean> map=new HashMap<>();
        dfsHelper(src,map,graph);


    }

    private static void dfsHelper(Integer src, Map<Integer, Boolean> map,Graph<Integer> graph) {
        map.put(src,true);
        System.out.print(src+" ");
        List<Integer> list=graph.adjList.get(src);
        if(list!=null){
            for(Integer element:list){
                if(map.get(element)==null || map.get(element).equals(false)){
                    dfsHelper(element,map,graph);
                }
            }
        }

    }

    public static void DfsTraversalOfGraph(Graph<Integer> graph,int src,int vertices){

        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[vertices];
        stack.push(src);
        visited[src]=true;
        System.out.print(src+" ");
        while(!stack.isEmpty()){
            int node=stack.peek();
            List<Integer> neighbors=graph.adjList.get(node);
            boolean visiedAdj=true;
            if(neighbors!=null) {
                for (int element : neighbors) {
                    if(visited[element]!=true){
                        visiedAdj=false;
                        visited[element]=true;
                        stack.push(element);
                        System.out.print(element+" ");
                        break;
                    }

                }
            }

            if(visiedAdj){
                stack.pop();
            }

        }


    }
}
