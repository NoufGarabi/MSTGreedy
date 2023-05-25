/**

The AFRouteMap class extends the Graph class and represents a route map for an air freight network.
It inherits the basic graph functionality from the Graph class and provides specific implementations for creating vertices and edges.
*/
package com.airfreighapp;

import com.graphframework.Edge;
import com.graphframework.Graph;
import com.graphframework.Vertex;
/**
 * 
 * The AFRouteMap class represents a route map for an air freight network.
 */
public class AFRouteMap extends Graph {

    /**
     * 
     * Constructs a new AFRouteMap object with the specified number of vertices and
     * directed/undirected flag.
     * 
     * @param numVerts   The number of vertices in the route map.
     * @param isDirected A flag indicating whether the route map is directed (true)
     *                   or undirected (false).
     */
    public AFRouteMap(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
    }

    /**
     * 
     * Creates a new edge between the given vertices with the specified weight.
     * 
     * @param vertex  The source vertex of the edge.
     * @param vertex2 The target vertex of the edge.
     * @param weight  The weight of the edge.
     * @return The created Route edge.
     */
    @Override
    public Edge createEdge(Vertex vertex, Vertex vertex2, int weight) {
        return new Route(vertex, vertex2, weight);
    }

    /**
     * 
     * Creates a new vertex with the given label.
     * 
     * @param label The label of the vertex.
     * @return The created Location vertex.
     */
    @Override
    public Vertex createVertex(String label) {
        return new Location(label);
    }
}
