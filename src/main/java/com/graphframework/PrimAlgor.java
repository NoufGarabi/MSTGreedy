/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

/**

PrimAlgor is a class that implements the Prim's algorithm for finding the minimum spanning tree (MST) of a graph.
It extends the MSTAlgor class.
*/
package com.graphframework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimAlgor extends MSTAlgor {
    List<Edge> MSTResultList;
    Graph graph;
    Set<Vertex> visitedVertices;
    MinHeap minHeap;
    List<Vertex> adjList;
    int numOfVertices;

    /**
     * 
     * Constructs a new PrimAlgor object.
     * Initializes the MSTResultList as an empty ArrayList.
     */
    public PrimAlgor(Graph graph) {
        super();
        MSTResultList = new ArrayList<>(); // store MST

        // get adj list of graph
        this.adjList = graph.getAdjList();

        // Get the number of vertices from the graph
        this.numOfVertices = graph.getVerticesNum();
        // Keep track of visited vertices
        this.visitedVertices = new HashSet<Vertex>();

        // Create a new min heap
        this.minHeap = new MinHeap(graph.getEdges().size());

        // Insert the first vertex into the min heap and give it a cost of 0
        Vertex firstVertex = adjList.get(0); // Get the first vertex from the adjacency list
        minHeap.insert(new HeapNode(firstVertex, 0, graph.createEdge(firstVertex, firstVertex, 0)));
    }

    /**
     * Implements the Prim's algorithm to find the minimum spanning tree of the
     * given graph.
     * 
     * @param graph The graph for which the minimum spanning tree needs to be found.
     */
    public List<Edge> MHPrimImplementation() {

        while (visitedVertices.size() < numOfVertices && !minHeap.isEmpty()) {
            HeapNode poppedNode = minHeap.pop(); // Extract the minimum node from the heap
            Vertex poppedVertex = poppedNode.getVertex(); // Get the vertex from the node
            Edge poppedEdge = poppedNode.getEdge();

            // If the vertex is already visited, skip it
            if (visitedVertices.contains(poppedVertex))
                continue;

            visitedVertices.add(poppedVertex); // Add the vertex to the visited vertices set
            MSTResultList.add(poppedEdge); // Add the minimum edge to the MST

            for (Edge e : poppedVertex.getAdjList()) {
                Vertex source = e.getSource();
                Vertex target = e.getTarget();

                if (source.equals(poppedVertex) && !visitedVertices.contains(target)) {
                    minHeap.insert(new HeapNode(target, e.getWeight(), e));

                } else if (target.equals(poppedVertex) && !visitedVertices.contains(source)) {
                    minHeap.insert(new HeapNode(source, e.getWeight(), e));

                }

            }
        }

        return MSTResultList;
    }

    /**
     * Displays the resulting minimum spanning tree (MST) constructed using Prim's
     * algorithm.
     */
    @Override
    public void displayResultingMST() {

        int result = 0;
        for (int i = 1; i < MSTResultList.size(); i++) {
            MSTResultList.get(i).displayInfo();
            result += MSTResultList.get(i).getWeight();
        }
        System.out.println("The cost of designed phone network: " + result);
    }
}