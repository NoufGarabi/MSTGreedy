/**

The Line class represents an edge between two vertices in a phone network graph.
It extends the Edge class from the graph framework.
*/
package com.phonenetworkapp;

import com.graphframework.Edge;
import com.graphframework.Vertex;

/**
 * 
 * The Line class represents an edge between two vertices in a phone network
 * graph.
 */
public class Line extends Edge {
    private int lLength; // The length of the line
    private Vertex source; // The source vertex of the line
    private Vertex target; // The target vertex of the line

    /**
     * 
     * Constructs a new Line object.
     */
    public Line() {
    }

    /**
     * 
     * Constructs a new Line object with the specified source, destination, and
     * weight.
     * 
     * @param source      The source vertex of the line.
     * @param destination The target vertex of the line.
     * @param weight      The weight of the line.
     */
    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
        this.lLength = weight * 5;
        this.source = source;
        this.target = destination;
    }

    /**
     * 
     * Returns the length of the line.
     * 
     * @return The length of the line.
     */
    public int getLength() {
        return lLength;
    }

    /**
     * 
     * Sets the length of the line.
     * 
     * @param length The length of the line.
     */
    public void setLength(int length) {
        this.lLength = length;
    }

    /**
     * 
     * Displays information about the line, including the source, target, and
     * length.
     */
    @Override
    public void displayInfo() {
        System.out.print("Office No." + (char) (Integer.parseInt(this.getSource().getLabel()) + 65));
        System.out.print(" - Office No." + (char) (Integer.parseInt(this.getTarget().getLabel()) + 65) + " ");
        System.out.println(": line length: " + this.lLength);
    }

    /**
     * 
     * Returns the source vertex of the line.
     * 
     * @return The source vertex of the line.
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * 
     * Sets the source vertex of the line.
     * 
     * @param source The source vertex of the line.
     */
    public void setSource(Office source) {
        this.source = source;
    }

    /**
     * 
     * Returns the target vertex of the line.
     * 
     * @return The target vertex of the line.
     */
    public Vertex getTarget() {
        return target;
    }

    /**
     * 
     * Sets the target vertex of the line.
     * 
     * @param target The target vertex of the line.
     */
    public void setTarget(Office target) {
        this.target = target;
    }
}