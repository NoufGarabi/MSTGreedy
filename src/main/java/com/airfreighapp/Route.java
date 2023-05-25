/**

The Route class represents an edge in an air freight network graph that represents a route between two locations.
It extends the Edge class from the graph framework.
*/
package com.airfreighapp;

import com.graphframework.Edge;
import com.graphframework.Vertex;

/**
 * 
 * The Route class represents an edge in an air freight network graph that
 * represents a route between two locations.
 */
public class Route extends Edge {

    /**
     * 
     * Constructs a new Route object with the specified source, target, and weight.
     * 
     * @param source The source vertex of the route.
     * @param target The target vertex of the route.
     * @param weight The weight of the route.
     */
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }

    /**
     * 
     * Displays information about the route, including its length.
     */
    @Override
    public void displayInfo() {
        System.out.println("--- route length: " + this.getWeight());
    }
}