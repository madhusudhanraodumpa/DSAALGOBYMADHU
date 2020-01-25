package com.org.learnby.graph;

public class GetAllEdge {
    public static void main(String args[]){
        //Graph<String> graph=new Graph<>(5);
        /*graph.addEdge("putin","modi",false);
        graph.addEdge("putin","trump",false);
        graph.addEdge("putin","pope",false);

        graph.addEdge("prabhu","modi",false);
        graph.addEdge("yogi","modi",true);
        graph.addEdge("yogi","prabhu",false);
        graph.addEdge("trump","modi",true);*/
        Graph<Integer> graph=new Graph<>(5);

        graph.addEdge(0,1,true);
        graph.addEdge(1,2,true);
        graph.addEdge(0,4,true);
        graph.addEdge(2,4,true);
        graph.addEdge(3,2,true);
        graph.addEdge(4,3,true);
        graph.addEdge(3,5,true);
        graph.printGraphEdges();


    }

}
