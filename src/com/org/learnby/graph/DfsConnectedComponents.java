package com.org.learnby.graph;

public class DfsConnectedComponents {
    public static void main(String args[]){
        Graph<String> graph=new Graph<>(7);
        graph.addEdge("Amristar","Jaipur",true);
        graph.addEdge("Amristar","Delhi",true);
        graph.addEdge("Delhi","Jaipur",true);
        graph.addEdge("Mumbai","Jaipur",true);
        graph.addEdge("Mumbai","Bhopal",true);
        graph.addEdge("Delhi","Bhopal",true);
        graph.addEdge("Mumbai","Banaglore",true);
        graph.addEdge("Agra","Delhi",true);
        graph.addEdge("Andaman","Nicobar",true);
        graph.addEdge("hyderabd","palasa",true);
        GraphDfsRecursion<String> dfsRecursion=new GraphDfsRecursion<>();
        dfsRecursion.dfs("Amristar",graph);

    }
}
