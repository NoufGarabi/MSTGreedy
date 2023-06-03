/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

/**

The Vertex class represents a vertex in a graph. Each vertex has a label,
visited flag to indicate whether it has been visited during a graph traversal,
and an adjacency list to keep track of its neighbors.
*/
package com.graphframework;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The Vertex class represents a vertex in a graph.
 */
public class Vertex {

    private String label; // The label of the vertex
    private boolean isVisited; // Flag to indicate whether the vertex has been visited
    private ArrayList<Edge> adjList; // The adjacency list of the vertex

    /**
     * 
     * Default constructor for the Vertex class.
     */
    public Vertex() {
    }

    /**
     * 
     * Constructor for the Vertex class that sets the label of the vertex and
     * initializes its visited flag to false and its adjacency list to an empty
     * ArrayList.
     * 
     * @param label The label of the vertex.
     */
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new ArrayList<>();
    }

    /**
     * 
     * Returns the label of the vertex.
     * 
     * @return The label of the vertex.
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * Sets the label of the vertex.
     * 
     * @param label The label to be set for the vertex.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * Returns the visited flag of the vertex.
     * 
     * @return The visited flag of the vertex.
     */
    public boolean isVisited() {
        return isVisited;
    }

    /**
     * 
     * Sets the visited flag of the vertex.
     * 
     * @param visited The value to set the visited flag for the vertex.
     */
    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    /**
     * 
     * Returns the adjacency list of the vertex.
     * 
     * @return The adjacency list of the vertex.
     */
    public List<Edge> getAdjList() {
        return adjList;
    }

    /**
     * 
     * Adds a vertex to the adjacency list of the vertex.
     * 
     * @param vertex The edge to be added to the adjacency list.
     */
    public void addToAdjList(Edge vertex) {
        adjList.add(vertex);
    }

    /**
     * 
     * Prints information about the vertex, including its label, visited flag, and
     * adjacency list.
     */
    public void displayInfo() {
        System.out.println("Vertex " + label + " is visited: " + isVisited);
        System.out.print("Adjacent list: ");
        for (Edge e : adjList) {
            System.out.print("source: " + e.getSource().getLabel() + " target: " + e.getTarget().getLabel()
                    + " weight: " + e.getWeight());
        }
        System.out.println();
    }
}