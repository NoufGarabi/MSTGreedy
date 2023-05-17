package com.graphframework;
public class BluePrintsGraph extends Graph{

    public BluePrintsGraph(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    protected Vertex createVertex(String label) {
        return new Office(label);
    }

    @Override
    protected Edge createEdge(Vertex v, Vertex u, int weight) {
        return new Line(v, u, weight);
    }
}
