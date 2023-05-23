package com.phonenetworkapp;

import com.graphframework.Edge;
import com.graphframework.Vertex;

public class Line extends Edge {
    private int lLength;
    private Vertex source;
    private Vertex target;

    public Line() {

    }

    // Constructor
    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
        this.lLength = weight * 5;
        this.source = source;
        this.target = destination;
    }

    public int getlLength() {
        return lLength;
    }

    public void setlLength(int lLength) {
        this.lLength = lLength;
    }

    @Override
    public void displayInfo() {
        System.out.print("Office No." + (char) (Integer.parseInt(this.getSource().getLabel()) + 65));
        System.out.print(" - Office No." + (char) (Integer.parseInt(this.getTarget().getLabel()) + 65) + " ");
        System.out.println(": line length: " + this.lLength);
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Office source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Office target) {
        this.target = target;
    }

}
