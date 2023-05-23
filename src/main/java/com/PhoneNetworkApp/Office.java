package com.phonenetworkapp;

import com.graphframework.Vertex;

public class Office extends Vertex {

    public Office(String label) {
        super(label);

    }

    // Method to set the correct value within the relevant constructor
    @Override
    public void setLabel(String label) {
        super.setLabel("O" + label);
    }

    
    @Override
    public void displayInfo() {
        System.out.println("Office No." + (char) (Integer.parseInt(getLabel() + 65)) + " ");
    }
}
