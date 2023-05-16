package com.graphframework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PrimAlgor extends MSTAlgor {
    List<Vertex> minSpaningTree;
    

    public PrimAlgor() {
        super();
        minSpaningTree =  new ArrayList<>();
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
       minHeap.insert(new HeapNode(adjList.get(0) ,0));

       while(vistedVertcies.size() < numOfVertcies){
        HeapNode poppedNode = minHeap.extractMin(); // extract min node from heap
        Vertex poppedVertex = poppedNode.getVertex(); // get vertex from node
        int cost = poppedNode.getKey(); // get key from node

        // if vertex is already visted skip it
        if(vistedVertcies.contains(poppedVertex))
        continue;

        // Add cost to the result of the MST
        result += cost;
        vistedVertcies.add(poppedVertex); // add vertex to visited vertcies set
        poppedVertex.setVisited(true); // mark vertex to visited

        for(Edge e : edgesList) {
            Vertex source = e.getSource();
            Vertex target = e.getTarget();

            if(source == poppedVertex && !vistedVertcies.contains(target)) {
                minHeap.insert(new HeapNode(target, e.getWeight()));
            } else if(target == poppedVertex && !vistedVertcies.contains(source)) {
                minHeap.insert(new HeapNode(source, e.getWeight()));
            }
        }
       }

       System.out.println(result);

    }

    @Override
    public void displayResultingMST() {
        throw new UnsupportedOperationException("Unimplemented method 'displayResultingMST'");
    }

}