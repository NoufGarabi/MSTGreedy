/**

The AFRouteMap class extends the Graph class and represents a route map for an air freight network.
It inherits the basic graph functionality from the Graph class and provides specific implementations for creating vertices and edges.
*/
package com.airfreighapp;

import com.graphframework.Edge;
import com.graphframework.Graph;
import com.graphframework.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
     * Reads a graph from a file with the given filename.
     * 
     * @param filename The name of the file to read the graph from.
     * 
     * @return The AFRouteMap object representing the read graph.
     * 
     * @throws FileNotFoundException If the specified file is not found.
     */
    public static AFRouteMap readGraphFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        // Read if graph is digraph or not
        String digraphLine = scanner.nextLine();
        String[] digraphParts = digraphLine.split(" ");
        int digraphValue = Integer.parseInt(digraphParts[1]);
        boolean isDirected = (digraphValue == 1);

        // Get vertices number
        int vertNum = scanner.nextInt();

        // Create new graph
        AFRouteMap routeMap = new AFRouteMap(vertNum, isDirected);

        // Get edges number
        int edgesNum = scanner.nextInt();

        // Create an array to store the vertices
        Location[] vertices = new Location[vertNum];

        for (int i = 0; i < edgesNum; i++) {
            char s1 = scanner.next().charAt(0); // Get label of source office
            char s2 = scanner.next().charAt(0); // Get label of target office

            // Create new offices if they don't exist in the array
            int v1Index = s1 - 65; // Convert label to index
            Location v1 = (Location) routeMap.getVertex(Integer.toString(v1Index));
            if (vertices[v1Index] == null) {
                vertices[v1Index] = (Location) routeMap.createVertex(s1 - 65 + "");
            }

            int v2Index = s2 - 65; // Convert label to index
            Location v2 = (Location) routeMap.getVertex(Integer.toString(v2Index));
            if (vertices[v2Index] == null) {
                vertices[v2Index] = (Location) routeMap.createVertex(s2 - 65 + "");
            }

            // Get weight of edge
            int w = scanner.nextInt();

            // Add edge to graph
            routeMap.addEdge(v1, v2, w);
        }

        scanner.close();
        return routeMap;
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
