package com.org.learnby.graph;

import java.util.*;

public class AdjacencyList {
    public static void main(String args[]){
        Graph<String> graph=new Graph<String>();
        graph.addEdge("putin","modi",false);
        graph.addEdge("putin","trump",false);
        graph.addEdge("putin","pope",false);

        graph.addEdge("prabhu","modi",false);
        graph.addEdge("yogi","modi",true);
        graph.addEdge("yogi","prabhu",false);
        graph.addEdge("trump","modi",true);
        graph.printEdges();
        System.out.println("............................");
        graph.bfs("putin");





    }

    public  static class Graph<T>{
        Map<T, List<T>> adjaList;
        Graph(){
            adjaList=new HashMap<>();
        }
        public void addEdge(T u,T v,Boolean bidDirection){
            List<T> listU=adjaList.get(u);
            if(listU==null){
                listU=new ArrayList<>();
            }
            listU.add(v);
            adjaList.put(u,listU);
            if(bidDirection){
                List<T> listV=adjaList.get(v);
                if(listV==null){
                    listV=new ArrayList<>();
                }
                listV.add(u);
                adjaList.put(v,listV);
            }



        }
        public void bfs(T src){
            Map<T,Boolean> visited=new HashMap<>();
            Queue<T> queue=new LinkedList<>();
            queue.add(src);
            visited.put(src,true);
            while(!queue.isEmpty()){
                T node=queue.peek();
                System.out.print(node+",");
                queue.poll();
                if(adjaList.get(node)!=null) {
                    for (T neigbors : adjaList.get(node)) {
                        if (!(visited.get(neigbors) != null && visited.get(neigbors))) {
                            queue.add(neigbors);
                            visited.put(neigbors, true);
                        }
                    }
                }

            }



        }

        public void printEdges(){

            for(Map.Entry<T,List<T>> entry:adjaList.entrySet()){
                System.out.print(entry.getKey()+"-->");
                List<T> list=entry.getValue();
                for(T t:list){
                    System.out.print(t+",");
                }
                System.out.println();
            }


        }


}


}