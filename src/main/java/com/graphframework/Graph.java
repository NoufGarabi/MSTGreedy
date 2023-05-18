package com.graphframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public abstract class Graph {

    private final int verticesNum; // number of vertices
    private final boolean digraph; // is the graph directed?
    private final List<Line> edges; // list of edges in the graph
    private final List<Office> adjList; // adjacency list for each vertex
    private int edgeNo = 0; // number of edges in the graph

    // Constructor to create a new graph with the given number of vertices and
    // directed/undirected property
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

    // Method to add an edge to the graph between the given vertices with the given
    // weight
    public void addEdge(Office v, Office u, int w) {
        Line e = createEdge(v, u, w);
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

    // Abstract method to create a vertex
    protected abstract Office createVertex(String label);

    // Abstract method to create an edge
    protected abstract Line createEdge(Office v, Office u, int weight);

    // Method to generate a random graph with the given number of edges
    public void makeGraph(BluePrintsGraph g) {
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

    // Method to print the graph in adjacency list representation
    public void printGraph() {
        System.out.println("\n== Adjacency List Representation ==");
        for (Office v : adjList) {
            System.out.print("No." + v.getLabel() + ": ");
            List<Office> neighbors = v.getAdjList();
            for (Office neighbor : neighbors) {
                System.out.print(neighbor.getLabel() + " ");
            }
            System.out.println();
        }
    }

    // Method to read a graph from a file with the given filename
    public static Graph readGraphFromFile(String filename, boolean isDirected) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int numVerts = scanner.nextInt();
        scanner.nextLine();

        Graph graph = new BluePrintsGraph(numVerts, isDirected);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            int src = Integer.parseInt(line[0]);
            int dest = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            graph.addEdge(graph.getVertex(src), graph.getVertex(dest), weight);
        }

        scanner.close();
        return graph;
    }

    // Method to get the vertex with the given label
    public Office getVertex(int label) {
        return adjList.get(label);
    }

    // Method to get the weight of the edge between the given vertices
    private int getEdgeWeight(Office v, Office u) {
        for (Line e : edges) {
            if (e.getSource().equals(v) && e.getTarget().equals(u)) {
                return e.getWeight();
            }
        }
        return -1; // indicates that there is no edge between v and u
    }

    // Method to check if there is an edge between the given vertices
    private boolean isConnected(int src, int dest, List<Office> list) {
        for (Office vertex : list.get(src).getAdjList()) {
            if (vertex.getLabel().equals(Integer.toString(dest))) {
                return true;
            }
        }
        return false;
    }

    public boolean isDigraph() {
        return digraph;
    }

    // Getters
    public int getVerticesNum() {
        return verticesNum;
    }

    public List<Line> getEdges() {
        return edges;
    }

    public List<Office> getAdjList() {
        return adjList;
    }

}
