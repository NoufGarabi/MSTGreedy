/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

/**

The Office class represents a vertex in a phone network graph that represents an office.
It extends the Vertex class from the graph framework.
*/
package com.phonenetworkapp;

import com.graphframework.Vertex;

/**
 * 
 * The Office class represents a vertex in a phone network graph that represents
 * an office.
 */
public class Office extends Vertex {

    /**
     * 
     * Constructs a new Office object with the specified label.
     * 
     * @param label The label of the office.
     */
    public Office(String label) {
        super(label);
    }

    /**
     * 
     * Sets the label of the office.
     * Overrides the setLabel method in the Vertex class to set the label in the
     * correct format.
     * 
     * @param label The label of the office.
     */
    @Override
    public void setLabel(String label) {
        super.setLabel("O" + label);
    }

    /**
     * 
     * Displays information about the office, including its label.
     */
    @Override
    public void displayInfo() {
        System.out.println("Office No." + (char) (Integer.parseInt(getLabel() + 65)) + " ");
    }
}