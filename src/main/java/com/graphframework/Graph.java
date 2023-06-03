/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

/**

The Graph class represents a graph data structure in Java.
It provides methods for creating, manipulating, and analyzing graphs.
The graph can be either directed or undirected.
*/
package com.graphframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    private final int verticesNum; // number of vertices
    private final boolean digraph; // is the graph directed?
    private final List<Edge> edges; // list of edges in the graph
    protected final List<Vertex> adjList; // adjacency list for each vertex
    private int edgeNo = 0; // number of edges in the graph

    /**
     * Constructs a new graph with the given number of vertices and
     * directed/undirected property.
     *
     * @param numVerts   The number of vertices in the graph.
     * @param isDirected Specifies whether the graph is directed (true) or
     *                   undirected (false).
     */
    public Graph(int numVerts, boolean isDirected) {
        this.verticesNum = numVerts;
        this.digraph = isDirected;
        this.edges = new ArrayList<>();
        this.adjList = new ArrayList<>();

        // Create a vertex for each number in the range [0, numVerts)
        for (int i = 0; i < verticesNum; i++) {
            adjList.add(createVertex(Integer.toString(i)));
        }
    }

    /**
     * Adds an edge to the graph between the given vertices with the given weight.
     *
     * @param vertex  The source vertex of the edge.
     * @param vertex2 The target vertex of the edge.
     * @param weight  The weight of the edge.
     */
    public void addEdge(Vertex vertex, Vertex vertex2, int weight) {
        Edge e = createEdge(vertex, vertex2, weight);
        vertex.addToAdjList(e);
        vertex2.addToAdjList(e); // add the edge to the adjacency list of vertex2

        this.edges.add(e);

        if (!digraph) {
            edgeNo += 2;
        } else {
            edgeNo++;
        }
    }

    /**
     * Creates a new Vertex object with the given label.
     *
     * @param label The label of the vertex.
     * @return The created Vertex object.
     */
    public Vertex createVertex(String label) {
        return new Vertex(label);
    }

    /**
     * Creates a new Edge object between the given source and target vertices with
     * the given weight.
     *
     * @param vertex  The source vertex of the edge.
     * @param vertex2 The target vertex of the edge.
     * @param weight  The weight of the edge.
     * @return The created Edge object.
     */
    public Edge createEdge(Vertex vertex, Vertex vertex2, int weight) {
        return new Edge(vertex, vertex2, weight);
    }

    /**
     * Generates a random graph with the specified number of edges.
     *
     * @param g The graph object to generate the random graph for.
     */
    public void makeGraph(Graph g) {
        Random randm = new Random();

        // Create a path of vertices with random weights
        for (int i = 0; i < verticesNum - 1; i++) {
            int weight = randm.nextInt(40) + 1;
            addEdge(adjList.get(i), adjList.get(i + 1), weight);
            if (!digraph) {
                addEdge(adjList.get(i + 1), adjList.get(i), weight); // if the graph is undirected, add a reverse edge
                // as well
            }
        }

        // Create additional edges until the desired number is reached
        int remEdges = edgeNo - (verticesNum - 1);
        for (int i = 0; i < remEdges; i++) {
            int srcVert = randm.nextInt(verticesNum);
            int destVert = randm.nextInt(verticesNum);

            // If the source and destination vertices are the same or already connected, try
            // again
            if (destVert == srcVert || isConnected(srcVert, destVert, adjList)) {
                i--;
                continue;
            }

            int weight = randm.nextInt(40) + 1;
            addEdge(adjList.get(srcVert), adjList.get(destVert), weight);
        }
    }

    /**
     * Prints the graph as an adjacency list representation.
     */
    public void printGraph() {
        System.out.println("\n== Adjacency List Representation ==");
        for (Vertex v : adjList) {
            System.out.println("Adjacency List of Vertex No. " + v.getLabel());
            List<Edge> neighbors = v.getAdjList();
            for (Edge neighbor : neighbors) {
                System.out.println("Source: " + neighbor.getSource().getLabel()
                        + "\nTarget: " + neighbor.getTarget().getLabel()
                        + "\nWeight: " + neighbor.getWeight());
                System.out.println();
            }
            System.out.println();
            System.out.println("=============");
        }
    }

    /**
     * Reads a graph from a file with the given filename.
     *
     * @param filename The name of the file to read the graph from.
     * @return The constructed Graph object.
     * @throws FileNotFoundException If the specified file is not found.
     */
    public static Graph readGraphFromFile(String filename) throws FileNotFoundException {
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
        Graph graph = new Graph(vertNum, isDirected);

        // Get edges number
        int edgesNum = scanner.nextInt();

        // Create an array to store the vertices
        Vertex[] vertices = new Vertex[vertNum];

        for (int i = 0; i < edgesNum; i++) {
            char s1 = scanner.next().charAt(0); // Get label of source office
            char s2 = scanner.next().charAt(0); // Get label of target office

            // Create new offices if they don't exist in the array
            int v1Index = s1 - 65; // Convert label to index
            Vertex v1 = graph.getVertex(Integer.toString(v1Index));
            if (vertices[v1Index] == null) {
                vertices[v1Index] = graph.createVertex(s1 - 65 + "");
            }

            int v2Index = s2 - 65; // Convert label to index
            Vertex v2 = graph.getVertex(Integer.toString(v2Index));
            if (vertices[v2Index] == null) {
                vertices[v2Index] = graph.createVertex(s2 - 65 + "");
            }

            // Get weight of edge
            int w = scanner.nextInt();

            // Add edge to graph
            Edge e = graph.createEdge(v1, v2, w);
            graph.addEdge(e.getSource(), e.getTarget(), e.getWeight());
        }

        scanner.close();
        return graph;
    }

    /**
     * Gets the vertex with the given label.
     *
     * @param label The label of the vertex to retrieve.
     * @return The Vertex object with the specified label, or null if not found.
     */
    public Vertex getVertex(String label) {
        for (Vertex vertex : adjList) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * Gets the edge between the given source and target vertices.
     *
     * @param src  The source vertex.
     * @param trgt The target vertex.
     * @return The Edge object representing the edge between the source and target
     *         vertices, or null if not found.
     */
    public Edge getEdge(Vertex src, Vertex trgt) {
        for (Edge edge : edges) {
            if (this.digraph) {
                if (edge.getSource().equals(src) && edge.getTarget().equals(trgt)) {
                    return edge;
                }
            }

            if (!this.digraph) {
                if (edge.getSource().equals(src) && edge.getTarget().equals(trgt)
                        || edge.getSource().equals(trgt) && edge.getTarget().equals(src)) {
                    return edge;
                }
            }
        }
        return null;
    }

    /**
     * Gets the weight of the edge between the given vertices.
     *
     * @param v The source vertex.
     * @param u The target vertex.
     * @return The weight of the edge between the source and target vertices, or -1
     *         if there is no edge between them.
     */
    public int getEdgeWeight(Vertex v, Vertex u) {
        for (Edge e : edges) {
            if (this.digraph) {
                if (e.getSource().equals(v) && e.getTarget().equals(u)) {
                    return e.getWeight();
                }
            }
            if (!this.digraph) {
                if (e.getSource().equals(v) && e.getTarget().equals(u)
                        || e.getSource().equals(u) && e.getTarget().equals(v)) {
                    return e.getWeight();
                }
            }
        }
        return -1; // indicates that there is no edge between v and u
    }

    /**
     * Checks if there is an edge between the given vertices.
     *
     * @param src      The index of the source vertex.
     * @param dest     The index of the target vertex.
     * @param adjList2 The adjacency list of vertices.
     * @return true if there is an edge between the source and target vertices,
     *         false otherwise.
     */
    private boolean isConnected(int src, int dest, List<Vertex> adjList2) {
        for (Edge vertex : adjList2.get(src).getAdjList()) {
            if (vertex.getSource().getLabel().equals(Integer.toString(dest))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the graph is directed.
     *
     * @return true if the graph is directed, false if it is undirected.
     */
    public boolean isDigraph() {
        return digraph;
    }

    /**
     * Gets the number of vertices in the graph.
     *
     * @return The number of vertices in the graph.
     */
    public int getVerticesNum() {
        return verticesNum;
    }

    /**
     * Gets the list of edges in the graph.
     *
     * @return The list of edges in the graph.
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Gets the adjacency list of vertices in the graph.
     *
     * @return The adjacency list of vertices in the graph.
     */
    public List<Vertex> getAdjList() {
        return adjList;
    }
}