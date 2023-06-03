package com.graphframework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public void computeDijkstraBasedSPAlg(Graph graph){
        for(Vertex v : graph.getAdjList()){
            SingleSourceSPAlg s = new SingleSourceSPAlg();
            s.computeDijkstraAlg(graph,v);
           // s.DisplayDijkstra();
//            System.out.println("Location " + (char)(Integer.parseInt(v.getLabel())+65));
            //SingleSourceSPAlg.computeDijkstraAlg(graph, v);
//            System.out.println("-------------------------------------------");
       
        }

    }
 
  
}