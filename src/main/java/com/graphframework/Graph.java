/**

Graph is an abstract class representing a graph data structure.
It provides methods to create and manipulate a graph.
*/
package com.graphframework;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public abstract class Graph {private final int verticesNum; // number of vertices
    private final boolean digraph; // is the graph directed?
    private final List<Line> edges; // list of edges in the graph
    private final List<Office> adjList; // adjacency list for each vertex
    private int edgeNo = 0; // number of edges in the graph
    
    /**
     * Constructs a new graph with the given number of vertices and directed/undirected property.
     *
     * @param numVerts   The number of vertices in the graph.
     * @param isDirected Indicates whether the graph is directed (true) or undirected (false).
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
     * @param v The source vertex.
     * @param u The target vertex.
     * @param w The weight of the edge.
     */
    public void addEdge(Office v, Office u, int w) {
        Line e = createEdge(v, u, w);
        v.addToAdjList(u);
    
        // If the graph is undirected, add a reverse edge as well
        if (!digraph) {
            u.addToAdjList(v);
        }
    
        this.edges.add(e);
    
        if (digraph) {
            edgeNo++;
        } else {
            edgeNo += 2;
        }
    }
    
    /**
     * Abstract method to create a vertex.
     *
     * @param label The label of the vertex.
     * @return The created vertex object.
     */
    protected abstract Office createVertex(String label);
    
    /**
     * Abstract method to create an edge.
     *
     * @param v      The source vertex.
     * @param u      The target vertex.
     * @param weight The weight of the edge.
     * @return The created edge object.
     */
    protected abstract Line createEdge(Office v, Office u, int weight);
    
    /**
     * Generates a random graph with the given number of edges.
     *
     * @param g The blueprint of the graph.
     */
    public void makeGraph(BluePrintsGraph g) {
        Random randm = new Random();
    
        // Create a path of vertices with random weights
        for (int i = 0; i < verticesNum - 1; i++) {
            int weight = randm.nextInt(40) + 1;
            addEdge(adjList.get(i), adjList.get(i + 1), weight);
            if (!digraph) {
                addEdge(adjList.get(i + 1), adjList.get(i), weight); // if the graph is undirected, add a reverse edge as well
            }
        }
    
        // Create additional edges until the desired number is reached
        int remEdges = edgeNo - (verticesNum - 1);
        for (int i = 0; i < remEdges; i++) {
            int srcVert = randm.nextInt(verticesNum);
            int destVert = randm.nextInt(verticesNum);
    
            // If the source and destination vertices are the same or already connected, try again
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
        for (Office v : adjList) {
            System.out.print("Office No. " + v.getLabel() + ": ");
            List<Office> neighbors = v.getAdjList();
            for (Office neighbor : neighbors) {
                System.out.print(neighbor.getLabel() + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Prints the graph with line lengths as an adjacency list representation.
     */
// Method to print the graph in adjacency list representation
// Method to print the graph in adjacency list representation
public void printGraphh() {
    System.out.println("\n== Adjacency List Representation ==");

    for (Office v : adjList) {
        List<Office> neighbors = v.getAdjList();
        for (Office neighbor : neighbors) {
            int weight = getEdgeWeight(v, neighbor);
            if (weight != -1) { // Skip printing if there is no edge
                String label = v.getLabel();
                String nLabel = neighbor.getLabel();
                int vIndex = 0;
                int nIndex = 0;
                char vChar;
                char nChar;

                try {
                    vIndex = Integer.parseInt(label);
                    nIndex = Integer.parseInt(nLabel);
                    vChar = (char) ('A' + vIndex);
                    nChar = (char) ('A' + nIndex);
                } catch (NumberFormatException e) {
                    vChar = label.charAt(0);
                    nChar = nLabel.charAt(0);
                }

                System.out
                        .println("Office No. " + vChar + " - Office No. " + nChar + ": Line length: " + weight * 5);
            }
        }
    }
}
    
    /**
     * Reads a graph from a file with the given filename.
     *
     * @param filename The name of the file containing the graph.
     * @return The constructed graph object.
     * @throws FileNotFoundException If the file is not found.
     */
    public static Graph readGraphFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        // Read if graph is digraph or not
        String digraphLine = scanner.nextLine();
        String[] digraphParts = digraphLine.split(" ");
        int digraphValue = Integer.parseInt(digraphParts[1]);
        boolean isDirected = (digraphValue == 1);

        // get vertices number
        int vertNum = scanner.nextInt();

        // create new graph
        Graph network = new BluePrintsGraph(vertNum, isDirected);

        // get edges number
        int edgesNum = scanner.nextInt();

        for (int i = 0; i < edgesNum; i++) {
            char s1 = scanner.next().charAt(0); // get label of source office
            char s2 = scanner.next().charAt(0);// get label of target office

            // create new offices
            Office v1 = new Office(s1 - 65 + "");
            Office v2 = new Office(s2 - 65 + "");

            // add office one to office 2 adj list
            v1.addToAdjList(v2);
    
            if (!network.isDigraph()) {
                v2.addToAdjList(v1);
            }

            // get weight of edge
            int w = scanner.nextInt();

            // add edge to graph
            network.addEdge(v1, v2, w);
        }
        scanner.close();
        return network;
    }
    
    /**
     * Gets the vertex with the given label.
     *
     * @param label The label of the vertex to retrieve.
     * @return The vertex object with the given label, or null if not found.
     */
    public Office getVertex(String label) {
        for (Office vertex : adjList) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    public Line getEdge(Office src, Office trgt) {
        for (Line edge : edges) {
            if(this.digraph){
            if (edge.getSource().equals(src) && edge.getTarget().equals(trgt)) {
                return edge;}
            }

            if(!this.digraph){
                if (edge.getSource().equals(src) && edge.getTarget().equals(trgt) || 
                edge.getSource().equals(trgt) && edge.getTarget().equals(src)) {
                    return edge;}
                }
        }
        return null;
    }
    
    /**
     * Gets the weight of the edge between the given vertices.
     *
     * @param v The source vertex.
     * @param u The target vertex.
     * @return The weight of the edge between v and u, or -1 if there is no edge.
     */
    int getEdgeWeight(Office v, Office u) {
        for (Line e : edges) {
            if(this.digraph){
            if (e.getSource().equals(v) && e.getTarget().equals(u)) {
                return e.getWeight();
            }}
            if(!this.digraph){
                if (e.getSource().equals(v) && e.getTarget().equals(u)|| e.getSource().equals(u) && e.getTarget().equals(v))  {
                    return e.getWeight();
                }}
        }
        return -1; // indicates that there is no edge between v and u
    }
    
    /**
     * Checks if there is an edge between the given vertices.
     *
     * @param src  The source vertex index.
     * @param dest The target vertex index.
     * @param list The adjacency list of vertices.
     * @return true if there is an edge between the vertices, false otherwise.
     */
    private boolean isConnected(int src, int dest, List<Office> list) {
        for (Office vertex : list.get(src).getAdjList()) {
            if (vertex.getLabel().equals(Integer.toString(dest))) {
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
     * @return The number of vertices.
     */
    public int getVerticesNum() {
        return verticesNum;
    }
    
    /**
     * Gets the list of edges in the graph.
     *
     * @return The list of edges.
     */
    public List<Line> getEdges() {
        return edges;
    }
    
    /**
     * Gets the adjacency list of vertices in the graph.
     *
     * @return The adjacency list.
     */
    public List<Office> getAdjList() {
        return adjList;
    }
    

}
