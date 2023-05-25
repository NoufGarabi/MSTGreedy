/**

The Edge class represents an edge in a graph. It contains information about
the source vertex, target vertex, and weight of the edge.
*/
package com.graphframework;

public class Edge {
    private Vertex source; // The source vertex of the edge
    private Vertex target; // The target vertex of the edge
    private int weight; // The weight of the edge
    private Vertex parent; // The parent vertex of the edge

    /**
     * Constructs an Edge object with the specified weight.
     *
     * @param weight The weight of the edge.
     */
    public Edge(int weight) {
        this.weight = weight;
    }

    /**
     * Default constructor for the Edge class.
     */
    public Edge() {
    }

    /**
     * Constructs an Edge object with the specified source vertex, target vertex,
     * and weight.
     *
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     * @param weight The weight of the edge.
     */
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     * Gets the parent vertex of the edge.
     *
     * @return The parent vertex of the edge.
     */
    public Vertex getParent() {
        return parent;
    }

    /**
     * Sets the parent vertex of the edge.
     *
     * @param parent The parent vertex of the edge.
     */
    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    /**
     * Returns the source vertex of the edge.
     *
     * @return The source vertex of the edge.
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Sets the source vertex of the edge.
     *
     * @param source The source vertex of the edge.
     */
    public void setSource(Vertex source) {
        this.source = source;
    }

    /**
     * Returns the target vertex of the edge.
     *
     * @return The target vertex of the edge.
     */
    public Vertex getTarget() {
        return target;
    }

    /**
     * Sets the target vertex of the edge.
     *
     * @param target The target vertex of the edge.
     */
    public void setTarget(Vertex target) {
        this.target = target;
    }

    /**
     * Returns the weight of the edge.
     *
     * @return The weight of the edge.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the edge.
     *
     * @param weight The weight of the edge.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Displays information about the edge, including the source vertex,
     * target vertex, and edge weight.
     */
    public void displayInfo() {
        System.out.print("Source vertex: " + getSource().getLabel());
        System.out.print(" Target vertex: " + getTarget().getLabel());
        System.out.println(" Edge weight: " + getWeight());
    }
}