package com.org.learnby.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDfsRecursion<T> {
    public void dfs(T src,Graph<T> graph){
        Map<T,Boolean> map=new HashMap<>();
        dfsUtil(src,map,graph);
        System.out.println();
        int component=1;
        for(Map.Entry<T,List<T>> entry:graph.adjList.entrySet()){
            if(map.get(entry.getKey())==null ||map.get(entry.getKey()).equals(false)){
                component++;
                dfsUtil(entry.getKey(),map,graph);
                System.out.println();

            }

        }
        System.out.println("Graph contains "+component+" components");
    }

    private void dfsUtil(T src, Map<T, Boolean> map,Graph<T> graph) {
        System.out.print(src+" ");
        map.put(src,true);
        List<T> list=graph.adjList.get(src);
        if(list!=null){
            for(T element:list){
                if(map.get(element)==null || map.get(element).equals(false)){
                    dfsUtil(element,map,graph);
                }
            }
        }

    }
}
