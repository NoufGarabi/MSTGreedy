package com.airfreighapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.graphframework.Edge;
import com.graphframework.Graph;
import com.graphframework.Vertex;

public class AFRouteMap extends Graph {

    public AFRouteMap(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
    }
// Reads a graph from a file with the given filename.
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
        Location v1 = (Location)routeMap.getVertex(Integer.toString(v1Index));
        if (vertices[v1Index] == null) {
            vertices[v1Index] = (Location) routeMap.createVertex(s1 - 65 + "");
        }

        int v2Index = s2 - 65; // Convert label to index
        Location v2 = (Location)routeMap.getVertex(Integer.toString(v2Index));
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
@Override
public Edge createEdge(Vertex vertex, Vertex vertex2, int weight) {
    return new Route(vertex, vertex2, weight);
}
@Override
public Vertex createVertex(String label) {
    return new Location(label);
}


    
}
