package com.graphframework;

public class Office extends Vertex{
    private String label;


    Office(String label){
        super(label);
    }

    @Override
    public void displayInfo() {
        System.out.println("Vertex " + this.label + " is visited: " + this.isVisited());
        System.out.print("Adjacent list: ");
        for (Vertex v : this.getAdjList()) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }
}
