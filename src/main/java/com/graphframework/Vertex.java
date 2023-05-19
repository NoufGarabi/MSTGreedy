/**

The Vertex class represents a vertex in a graph. Each vertex has a label,
visited flag to indicate whether it has been visited during a graph
traversal, and an adjacency list to keep track of its neighbors.
*/
package com.graphframework;
import java.util.ArrayList;
import java.util.List;

import com.phonenetworkapp.Office;

public class Vertex {
private String label; // the label of the vertex
private boolean isVisited; // flag to indicate whether the vertex has been visited
private List<Office> adjList; // the adjacency list of the vertex
/**
 * Default constructor for the Vertex class.
 */
public Vertex() {
}

/**
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
 * Returns the label of the vertex.
 *
 * @return The label of the vertex.
 */
public String getLabel() {
    return label;
}

/**
 * Sets the label of the vertex.
 *
 * @param label The label to set for the vertex.
 */
public void setLabel(String label) {
    this.label = label;
}

/**
 * Returns the visited flag of the vertex.
 *
 * @return true if the vertex has been visited, false otherwise.
 */
public boolean isVisited() {
    return isVisited;
}

/**
 * Sets the visited flag of the vertex.
 *
 * @param visited The value to set for the visited flag.
 */
public void setVisited(boolean visited) {
    isVisited = visited;
}

/**
 * Returns the adjacency list of the vertex.
 *
 * @return The adjacency list of the vertex.
 */
public List<Office> getAdjList() {
    return adjList;
}

/**
 * Adds a vertex to the adjacency list of the vertex.
 *
 * @param vertex The vertex to add to the adjacency list.
 */
public void addToAdjList(Office vertex) {
    this.adjList.add(vertex);
}

/**
 * Prints information about the vertex, including its label, visited flag, and adjacency list.
 */
public void displayInfo() {
    System.out.println("Vertex " + label + " is visited: " + isVisited);
    System.out.print("Adjacent list: ");
    for (Office v : adjList) {
        System.out.print(v.getLabel() + " ");
    }
    System.out.println();
}
}