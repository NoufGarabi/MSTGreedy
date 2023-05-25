/**

The Location class represents a vertex in an air freight network graph that represents a location or city.
It extends the Vertex class from the graph framework.
*/
package com.airfreighapp;

import com.graphframework.Vertex;

/**
 * 
 * The Location class represents a vertex in an air freight network graph that
 * represents a location or city.
 */
public class Location extends Vertex {
    private String city;

    /**
     * 
     * Constructs a new Location object with the specified city.
     * 
     * @param city The city associated with the location.
     */
    public Location(String city) {
        this.city = city;
    }

    /**
     * 
     * Sets the label of the location, prepending it with the prefix "loc".
     * 
     * @param label The label to set for the location.
     */
    @Override
    public void setLabel(String label) {
        super.setLabel("loc" + label);
    }

    /**
     * 
     * Returns the city associated with the location.
     * 
     * @return The city of the location.
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * Sets the city for the location.
     * 
     * @param city The city to set for the location.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * Displays information about the location, including its city.
     */
    @Override
    public void displayInfo() {
        System.out.println("C : city " + this.city);
    }
}