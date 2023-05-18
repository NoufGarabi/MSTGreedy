package com.graphframework;
public class BluePrintsGraph extends Graph{

    public BluePrintsGraph(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    protected Office createVertex(String label) {
        return new Office(label);
    }

    @Override
    protected Line createEdge(Office v, Office u, int weight) {
        return new Line(v, u, weight);
    }
}
