package com.graphframework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public void computeDijkstraBasedSPAlg(Graph graph){
        for(Vertex v : graph.getAdjList()){
            SingleSourceSPAlg s = new SingleSourceSPAlg();
            s.computeDijkstraAlg(graph,v);
            // s.DisplayDijkstra();
            
        
   
       
        }

    }
 
  
}
