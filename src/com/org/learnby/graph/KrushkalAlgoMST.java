package com.org.learnby.graph;

import java.util.*;

public class KrushkalAlgoMST {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int v=sc.nextInt();
        int e=sc.nextInt();
        List<Edge> edges=new ArrayList<>();
        Set<Integer> vertices=new HashSet<>();
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int w=sc.nextInt();

            Edge edge=new Edge(s,d,w);
            edges.add(edge);
            vertices.add(s);
            vertices.add(d);
        }
        krushkal(edges,v,e,vertices);


    }

    private static void krushkal(List<Edge> edges, int v, int e,Set<Integer> vertices) {
        edges.sort((e1,e2)->Integer.compare(e1.weight,e2.weight));
        Set<Edge> mstEdges=new HashSet<>();
        DisjointSet disjointSet=new DisjointSet();

        for (Iterator<Integer> it = vertices.iterator(); it.hasNext(); ) {
            int vertex=it.next();
            disjointSet.makeSet(vertex);
        }
        for(Edge edge:edges) {
            long root1=disjointSet.findSet(new Long(edge.src));
            long root2=disjointSet.findSet(new Long(edge.dest));
            if(root1==root2){
                continue;
            }else {
                mstEdges.add(edge);
                disjointSet.union(new Long(edge.src),new Long(edge.dest));
            }
        }

        for(Edge edge:mstEdges){
            System.out.println(edge.src+" --> "+edge.dest+"  -->weigth is "+edge.weight);


        }


       }




}
class Edge{
    int src;
    int dest;
    int weight;
    public Edge(int src,int dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}
