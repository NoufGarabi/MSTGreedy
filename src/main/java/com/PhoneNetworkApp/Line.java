package com.phonenetworkapp;

import com.graphframework.Edge;

public class Line extends Edge {
    private int lLength;
    private Office source;
    private Office target;


    public Line() {
       
    }



    // Constructor
    public Line(Office source, Office destination, int weight) {
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
        System.out.print("Office No." + (char)(Integer.parseInt(this.getSource().getLabel()) + 65));
        System.out.print(" - Office No." + (char)(Integer.parseInt(this.getTarget().getLabel())+ 65) + " ");
        System.out.println(": line length: " + this.lLength);
    }



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

}
