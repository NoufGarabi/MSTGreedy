package com.graphframework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public void computeDijkstraBasedSPAlg(Graph graph){
        SingleSourceSPAlg dikjstra = new SingleSourceSPAlg();
        for(Vertex v : graph.getAdjList()){
            dikjstra.computeDijkstraAlg(graph, v);
        }

    }
}
