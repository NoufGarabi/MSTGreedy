package com.graphframework;

public class Vertex {
    private String label;
    private boolean isVisited;

    // main Constructor
    public Vertex(String label, boolean isVisited) {
        this.label = label;
        this.isVisited = isVisited;
    }

    public static void displayInfo() {
        //TODO: implmenet function
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
}
