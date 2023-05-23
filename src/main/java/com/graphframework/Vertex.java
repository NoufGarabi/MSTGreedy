/**

The Vertex class represents a vertex in a graph. Each vertex has a label,
visited flag to indicate whether it has been visited during a graph
traversal, and an adjacency list to keep track of its neighbors.
*/
package com.graphframework;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String label; // the label of the vertex
    private boolean isVisited; // flag to indicate whether the vertex has been visited
    private ArrayList<Edge> adjList; // the adjacency list of the vertex

    // Default constructor for the Vertex class.
    public Vertex() {
    }

    /**
     * Constructor for the Vertex class that sets the label of the vertex and
     * initializes its visited flag to false and its adjacency list to an empty
     * ArrayList.
     */
    public Vertex(String label2) {
        this.label = label2;
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
    public List<Edge> getAdjList() {
        return adjList;
    }

    // Adds a vertex to the adjacency list of the vertex.
    public void addToAdjList(Edge vertex2) {
        adjList.add(vertex2);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(adjList.getClass().getName());
        }

    }

    /**
     * Prints information about the vertex, including its label, visited flag, and
     * adjacency list.
     */
    public void displayInfo() {
        System.out.println("Vertex " + label + " is visited: " + isVisited);
        System.out.print("Adjacent list: ");
        for (Edge e : adjList) {
            System.out.print(e.getSource().getLabel() + " " + e.getTarget().getLabel() + "W: " + e.getWeight());
        }
        System.out.println();
    }

    public Vertex getSource() {
        return null;
    }

    public Vertex getTarget() {
        return null;
    }
}