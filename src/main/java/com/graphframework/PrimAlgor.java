package com.graphframework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PrimAlgor extends MSTAlgor {

    public PrimAlgor() {
        super();
    }

    public static void MHPrimImplementation(Graph graph) {
        int cost = 0; // count cost of MST
        Set<Vertex> vistedVertcies = new HashSet<Vertex>(); // set to track visted vertcies
        MinHeap minHeap = new MinHeap(graph.getVerts()); // min heap of edges
        List<Vertex> vertcies = graph.getAdjList(); // get adj list of graph
        List<Edge> edges = graph.getEdges();

        // add first vertex of the graph to the min heap
        minHeap.insert(new Edge(vertcies.get(1), vertcies.get(1), 0));

        // loop through vertcies and get min edges to add to MST
        // loop runs for V - 1 which the min number of edges allowed for a
        // graph to be acyclic and connected.
        while (vistedVertcies.size() < graph.getVerts()) {
            // get vertex with min cost from heap
            Edge e = minHeap.remove();
            int edgeCost = e.getWeight();
            Vertex vertex = e.getSource();

            // check if the vertex already exist in visted set
            if (vistedVertcies.contains(vertex))
                continue;

            // add weight to cost calculator and vertex to visted set
            cost += edgeCost;
            vistedVertcies.add(vertex);

            // loop through all vertcies connected to the vertex and add them to heap
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getSource() == vertex && !vistedVertcies.contains(edges.get(i).getTarget()))
                    minHeap.insert(edges.get(i));
            }

        }

        System.out.println(cost);

    }

    @Override
    public void displayResultingMST() {
        throw new UnsupportedOperationException("Unimplemented method 'displayResultingMST'");
    }

}