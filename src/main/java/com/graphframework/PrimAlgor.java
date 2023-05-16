package com.graphframework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

       //insert first vertex in the mean heap and give it a cost of 0
       minHeap.insert(new HeapNode(adjList.get(0) ,0));

       // fill min heap with all vertcies in the graph and assign them a cost of
       // max value
    //    for(int i=1; i<adjList.size(); i++){
    //     minHeap.insert(new HeapNode(adjList.get(i), Integer.MAX_VALUE));
    //    }

       while(vistedVertcies.size() < numOfVertcies){
        HeapNode poppedNode = minHeap.extractMin(); // extract min node from heap
        Vertex poppVertex = poppedNode.getVertex(); // get vertex from node
        int cost = poppedNode.getKey(); // get key from node

        // if vertex is already visted skip it
        if(vistedVertcies.contains(poppVertex))
        continue;

        result += cost;
        vistedVertcies.add(poppVertex);

        for(Edge e : edgesList) {
            Vertex source = e.getSource();
            Vertex target = e.getTarget();

            if(source == poppVertex && !vistedVertcies.contains(target)) {
                minHeap.insert(new HeapNode(target, e.getWeight()));
            } else if(target == poppVertex && !vistedVertcies.contains(source)) {
                minHeap.insert(new HeapNode(source, e.getWeight()));
            }
        }
       }

       System.out.println(result);
    //    Iterator<Vertex> vistedVirtcesIterator = vistedVertcies.iterator();
    //    while(vistedVirtcesIterator.hasNext()){
    //     System.out.println(vistedVirtcesIterator.next().getLabel());
    //    }

    }

    @Override
    public void displayResultingMST() {
        throw new UnsupportedOperationException("Unimplemented method 'displayResultingMST'");
    }

}