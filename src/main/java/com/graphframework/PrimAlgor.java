package com.graphframework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PrimAlgor extends MSTAlgor {
    List<Edge> MSTResultList;
    

    public PrimAlgor() {
        super();
        MSTResultList =  new ArrayList<>();
    }

    public void MHPrimImplementation(Graph graph) {

        // get the number of vertcies from graph
       int numOfVertcies = graph.getVerticesNum();
       // get the adjList from graph
       List<Vertex> adjList = graph.getAdjList();

       // get edges of graph
       List<Edge> edgesList = graph.getEdges();

       int result = 0; // track spanning tree cost

       // keep track of visted vertcies
       Set<Vertex> vistedVertcies = new HashSet<Vertex>();
       MinHeap minHeap = new MinHeap(edgesList.size()); // create a new min heap
       //insert first vertex in the min heap and give it a cost of 0
       Vertex firstVertex = adjList.get(0); // get first vertex from adj list
       minHeap.insert(new HeapNode(firstVertex ,0,graph.createEdge(firstVertex, firstVertex, 0)));

       while(vistedVertcies.size() < numOfVertcies){
        HeapNode poppedNode = minHeap.extractMin(); // extract min node from heap
        Vertex poppedVertex = poppedNode.getVertex(); // get vertex from node
        Edge poppEdge = poppedNode.getEdge();
        int cost = poppedNode.getKey(); // get key from node

        // if vertex is already visted skip it
        if(vistedVertcies.contains(poppedVertex))
        continue;

        // Add cost to the result of the MST
        result += cost;
        vistedVertcies.add(poppedVertex); // add vertex to visited vertcies set
        poppedVertex.setVisited(true); // mark vertex to visited
        MSTResultList.add(poppEdge); // add min edge to MST

        for(Edge e : edgesList) {
            Vertex source = e.getSource();
            Vertex target = e.getTarget();

            if(source == poppedVertex && !vistedVertcies.contains(target)) {
                minHeap.insert(new HeapNode(target, e.getWeight(), e));
            } else if(target == poppedVertex && !vistedVertcies.contains(source)) {
                minHeap.insert(new HeapNode(source, e.getWeight(),e));
            }
    
       }
    }
       System.out.println("Minmum cost is:" + result);
       displayResultingMST();

    }

    @Override
    public void displayResultingMST() {
        for (int i = 1; i< MSTResultList.size(); i++){
            MSTResultList.get(i).displayInfo();
        }
    }

}