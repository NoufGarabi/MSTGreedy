/**

The BluePrintsGraph class extends the Graph class and represents a graph specifically designed for blueprints.
It inherits the basic graph functionality from the Graph class and provides specific implementations for creating vertices and edges.
*/
package com.PhoneNetworkApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.graphframework.Edge;
import com.graphframework.Graph;
import com.graphframework.Vertex;

/**
 * 
 * The BluePrintsGraph class represents a graph specifically designed for
 * blueprints.
 */
public class BluePrintsGraph extends Graph {

    /**
     * 
     * Constructor for the BluePrintsGraph class.
     * 
     * @param numVerts   The number of vertices in the graph.
     * @param isDirected Flag indicating whether the graph is directed or not.
     */
    public BluePrintsGraph(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
    }

    /**
     * 
     * Reads a graph from a file with the given filename and constructs a
     * BluePrintsGraph object.
     * 
     * @param filename The name of the file to read the graph from.
     * 
     * @return The constructed BluePrintsGraph object.
     * 
     * @throws FileNotFoundException if the specified file is not found.
     */
    public static BluePrintsGraph readGraphFromFile(String filename) throws FileNotFoundException {
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
        BluePrintsGraph network = new BluePrintsGraph(vertNum, isDirected);

        // Get edges number
        int edgesNum = scanner.nextInt();

        // Create an array to store the vertices
        Office[] vertices = new Office[vertNum];

        for (int i = 0; i < edgesNum; i++) {
            char s1 = scanner.next().charAt(0); // Get label of source office
            char s2 = scanner.next().charAt(0); // Get label of target office

            // Create new offices if they don't exist in the array
            int v1Index = s1 - 65; // Convert label to index
            Office v1 = (Office) network.getVertex(Integer.toString(v1Index));
            if (vertices[v1Index] == null) {
                vertices[v1Index] = (Office) network.createVertex(s1 - 65 + "");
            }

            int v2Index = s2 - 65; // Convert label to index
            Office v2 = (Office) network.getVertex(Integer.toString(v2Index));
            if (vertices[v2Index] == null) {
                vertices[v2Index] = (Office) network.createVertex(s2 - 65 + "");
            }

            // Get weight of edge
            int w = scanner.nextInt();

            // Add edge to graph
            network.addEdge(v1, v2, w);
        }

        scanner.close();
        return network;
    }

    /**
     * 
     * Creates a new vertex with the given label.
     * 
     * @param label The label of the vertex.
     * @return The created vertex.
     */
    @Override
    public Vertex createVertex(String label) {
        return new Office(label);
    }

    /**
     * 
     * Creates a new edge between the given vertices with the specified weight.
     * 
     * @param v      The source vertex of the edge.
     * @param u      The target vertex of the edge.
     * @param weight The weight of the edge.
     * @return The created edge.
     */
    @Override
    public Edge createEdge(Vertex v, Vertex u, int weight) {
        return new Line(v, u, weight);
    }
}