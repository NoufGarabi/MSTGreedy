package com.graphframework;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * The Vertex class represents a vertex in a graph. Each vertex has a label,
 * visited flag to indicate whether it has been visited during a graph
 * traversal, and an adjacency list to keep track of its neighbors.
 */
public class Vertex {

    private String label; // the label of the vertex
    private boolean isVisited; // flag to indicate whether the vertex has been visited
    private List<Office> adjList; // the adjacency list of the vertex


    // Default constructor for Vertex class.
    public Vertex() {
    }

    /**
     * Constructor for Vertex class that sets the label of the vertex and
     * initializes its visited flag to false and its adjacency list to an empty
     * ArrayList.
     */
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new ArrayList<>();
    }


    // Returns the label of the vertex.
    public String getLabel() {
        return label;
    }

    // Sets the label of the vertex.
    public void setLabel(String label) {
        this.label = label;
    }


    // Returns the visited flag of the vertex.
    public boolean isVisited() {
        return isVisited;
    }

   
    // Sets the visited flag of the vertex.
    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    
    // Returns the adjacency list of the vertex.
    public List<Office> getAdjList() {
        return adjList;
    }

   
    // Adds a vertex to the adjacency list of the vertex.
    public void addToAdjList(Office vertex) {
        adjList.add(vertex);
    }


    // Prints information about the vertex, including its label, visited flag, and adjacency list.
    public void displayInfo() {
        System.out.println("Vertex " + label + " is visited: " + isVisited);
        System.out.print("Adjacent list: ");
        for (Vertex v : adjList) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }
}
