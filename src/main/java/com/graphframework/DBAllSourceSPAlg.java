/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

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
