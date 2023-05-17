package com.graphframework;

public class Edge {

    private Vertex source; // The source vertex of the edge
    private Vertex target; // The target vertex of the edge
    private int weight; // The weight of the edge

    // Main Constructor
    public Edge(int weight) {
        this.weight = weight;
    }

    // Default Constructor
    public Edge() {
    }

    // Constructor with arguments
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    // Getter and Setter methods for source, target, and weight
    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
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
        // System.out.println("Edge information:");
        System.out.print("Source vertex: " + getSource().getLabel());
<<<<<<< HEAD
        System.out.print(" Target vertex: " + getTarget().getLabel());
=======
        System.out.print(" Target vertex: " + getTarget());
>>>>>>> e0fc26d (edited display edge info method in edge class)
        System.out.println(" Edge weight: " + getWeight());
    }
}
