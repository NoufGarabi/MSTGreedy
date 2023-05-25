package com.graphframework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public void computeDijkstraBasedSPAlg(Graph graph){
        for(Vertex v : graph.getAdjList()){
            System.out.println("Location " + v.getLabel());
            SingleSourceSPAlg.computeDijkstraAlg(graph, v);
            System.out.println();
            System.out.println();
        }

    }
}
