package com.graphframework;

public class Line extends Edge {
    private int lLength;

    // Constructor
    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
        this.lLength = weight * 5;
    }

    public int getlLength() {
        return lLength;
    }

    public void setlLength(int lLength) {
        this.lLength = lLength;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Line Length: " + lLength);
    }

   
}
