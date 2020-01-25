package com.org.learnby.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph<T> {
    int vertex;
    Map<T, List<T>> adjList=new HashMap<>();
    public Graph(int vertex){
        this.vertex=vertex;
    }
    public void addEdge(T src,T dest,boolean biDirection){
        List<T> srcList=adjList.get(src);
        if(srcList==null){
             srcList=new ArrayList<>();
        }
        srcList.add(dest);
        adjList.put(src,srcList);
        if(biDirection){
         List<T> destList=adjList.get(dest);
         if(destList==null){
             destList=new ArrayList<>();
         }
         destList.add(src);
         adjList.put(dest,destList);
        }
    }
    public void printGraphEdges(){
        for(Map.Entry<T,List<T>> entry:adjList.entrySet()){
            System.out.print(entry.getKey()+"-->");
            List<T> list=entry.getValue();
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
            System.out.println();
        }
    }
}
