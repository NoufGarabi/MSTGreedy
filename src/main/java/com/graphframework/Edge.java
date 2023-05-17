package com.graphframework;

public class Edge {

    private Office source; // The source vertex of the edge
    private Office target; // The target vertex of the edge
    private int weight; // The weight of the edge

    // Main Constructor
    public Edge(int weight) {
        this.weight = weight;
    }

    // Default Constructor
    public Edge() {
    }

    // Constructor with arguments
    public Edge(Office source, Office target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    // Getter and Setter methods for source, target, and weight
    public Office getSource() {
        return source;
    }

    public void setSource(Office source) {
        this.source = source;
    }

    public Office getTarget() {
        return target;
    }

    public void setTarget(Office target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Display information about the Edge
    public void displayInfo() {
        System.out.println("Edge information:");
        System.out.println("Source vertex: " + getSource());
        System.out.println("Target vertex: " + getTarget());
        System.out.println("Edge weight: " + getWeight());
    }
}
