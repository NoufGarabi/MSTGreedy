package com.phonenetworkapp;

import java.util.ArrayList;
import java.util.List;

import com.graphframework.Vertex;

public class Office extends Vertex {
    private List<Office> adjList; // the adjacency list of the vertex
    
    public Office(String label) {
        super(label);
        setLabel(label); // Make sure that it's in correct format
        adjList = new ArrayList<>();
    }

    @Override
    public void setLabel(String label) {
        // if (!label.matches("^O\\d+$")) {
        //     throw new IllegalArgumentException("Office label must start with 'O' followed by a unique number");
        // }
        super.setLabel(label);
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


    @Override
    public void displayInfo() {
        System.out.println("Office No." + (char)(Integer.parseInt(getLabel() + 65)) + " ");
    }
}
