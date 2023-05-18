package com.PhoneNetworkApp;

import com.graphframework.Vertex;

public class Office extends Vertex {
    public Office(String label) {
        super(label);
        setLabel(label); // Make sure that it's in correct format
    }

    @Override
    public void setLabel(String label) {
        // if (!label.matches("^O\\d+$")) {
        //     throw new IllegalArgumentException("Office label must start with 'O' followed by a unique number");
        // }
        super.setLabel(label);
    }

    @Override
    public void displayInfo() {
        System.out.println("Office information:");
        System.out.println("Label: " + getLabel());
        System.out.println("Visited: " + isVisited());
        System.out.print("Adjacent list: ");
        for (Vertex v : getAdjList()) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }
}
