package com.graphframework;

import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public class BluePrintsGraph extends Graph{

    public BluePrintsGraph(int numVerts, boolean isDirected) {
        super(numVerts, isDirected);
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
