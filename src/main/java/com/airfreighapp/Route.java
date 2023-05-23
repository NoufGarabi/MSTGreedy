package com.airfreighapp;

import com.graphframework.Edge;
import com.graphframework.Vertex;

public class Route extends Edge{

    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }

    @Override
    public void displayInfo() {
        System.out.println("--- route length: " + this.getWeight());
    }
    
}
