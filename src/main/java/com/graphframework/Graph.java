package com.graphframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Class to represent a graph
public class Graph {

    private final int verts; // number of vertices
    private final boolean digraph; // is the graph directed?
    private final List<Edge> edges; // list of edges in the graph
    private final List<Vertex> adjList; // adjacency list for each vertex
    private int edgeNo = 0; // number of edges in the graph

    // Constructor to create a new graph with the given number of vertices and directed/undirected property
    public Graph(int numVerts, boolean isDirected) {
        this.verts = numVerts;
        this.digraph = isDirected;
        this.edges = new ArrayList<>();
        this.adjList = new ArrayList<>();

        // Create a vertex for each number in the range [0, numVerts)
        for (int i = 0; i < verts; i++) {
            adjList.add(new Vertex(i));
        }
    }

    // Method to add an edge to the graph between the given vertices with the given weight
    public void addEdge(Vertex v, Vertex u, int w) {
        Edge e = new Edge(v, u, w);
        v.addToAdjList(u);

        // If the graph is undirected, add a reverse edge as well
        if (!digraph) {
            u.addToAdjList(v);
        }

        edges.add(e);

        if (digraph) {
            edgeNo++;
        } else {
            edgeNo += 2;
        }
    }

    // Method to generate a random graph with the given number of edges
    public void makeGraph(Graph graph) {
        Random randm = new Random();

        // Create a path of vertices with random weights
        for (int i = 0; i < verts - 1; i++) {
            int weight = randm.nextInt(40) + 1;
            addEdge(adjList.get(i), adjList.get(i + 1), weight);
            if (!digraph) {
                addEdge(adjList.get(i + 1), adjList.get(i), weight); // if the graph is undirected, add a reverse edge as well
            }
        }

        // Create additional edges until the desired number is reached
        int remEdges = edgeNo - (verts - 1);
        for (int i = 0; i < remEdges; i++) {
            int srcVert = randm.nextInt(verts);
            int destVert = randm.nextInt(verts);

            // If the source and destination vertices are the same or already connected, try again
            if (destVert == srcVert || isConnected(srcVert, destVert, adjList)) {
                i--;
                continue;
            }

            int weight = randm.nextInt(40) + 1;
            addEdge(adjList.get(srcVert), adjList.get(destVert), weight);
        }
    }

    // Method to print the graph in adjacency list representation
    public void printGraph() {
        System.out.println("\n== Adjacency List Representation ==");
        for (Vertex v : adjList) {
            System.out.print("No." + v.getLabel() + ": ");
            for (Vertex u : v.getAdjList()) {
                System.out.print("(" + u.getLabel() + ", " + getEdgeWeight(v, u) + ") ");
            }
            System.out.println();
        }
    }

    // Method to get the weight of the edge between the given vertices
    private int getEdgeWeight(Vertex v, Vertex u) {
        for (Edge e : edges) {
            if (e.getSource().equals(v) && e.getTarget().equals(u)) {
                return e.getWeight();
            }
        }
        return -1; // indicates that there is no edge between v and u
    }

    // Check if two vertices are connected in the graph
    private boolean isConnected(int src, int dest, List<Vertex> adjList) {
        Vertex srcVertex = adjList.get(src);
        Vertex destVertex = adjList.get(dest);
        return srcVertex.getAdjList().contains(destVertex);
    }

    // Reads graph data from a file and constructs a Graph object from it.
    public static Graph readGraphFromFile(String fileName) {
    try {
        // Open the file and create a scanner to read from it
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Read the first line to determine if the graph is directed or undirected
        boolean isDirected = false;
        String[] firstLine = scanner.nextLine().split(" ");
        if (firstLine[0].equals("digraph") && firstLine[1].equals("1")) {
            isDirected = true;
        }

        // Read the second line to determine the number of vertices and edges
        String[] secondLine = scanner.nextLine().split(" ");
        int numVerts = Integer.parseInt(secondLine[0]);
        int numEdges = Integer.parseInt(secondLine[1]);

        // Create a new Graph object with the given number of vertices and directed/undirected property
        Graph graph = new Graph(numVerts, isDirected);

        // Read the remaining lines to add edges to the graph
        for (int i = 0; i < numEdges; i++) {
            String[] line = scanner.nextLine().split(" ");
            Vertex v = graph.getAdjList().get(line[0].charAt(0) - 'A');
            Vertex u = graph.getAdjList().get(line[1].charAt(0) - 'A');
            int weight = Integer.parseInt(line[2]);
            graph.addEdge(v, u, weight);
        }

        scanner.close();
        return graph;

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + fileName);
        return null;
    }
}

    public boolean isDigraph() {
        return digraph;
    }

    // Getters
    public int getVerts() {
        return verts;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getAdjList() {
        return adjList;
    }
    
}
