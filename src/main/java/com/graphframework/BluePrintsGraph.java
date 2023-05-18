/**

The BluePrintsGraph class extends the Graph class and represents a graph specifically designed for blueprints.
It inherits the basic graph functionality from the Graph class and provides specific implementations for creating vertices and edges.
*/
package com.graphframework;
import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public class BluePrintsGraph extends Graph {
/**
 * Constructor for the BluePrintsGraph class.
 *
 * @param numVerts   The number of vertices in the graph.
 * @param isDirected A flag indicating whether the graph is directed or not.
 */
public BluePrintsGraph(int numVerts, boolean isDirected) {
    super(numVerts, isDirected);
}

/**
 * Creates a new vertex with the given label.
 *
 * @param label The label of the vertex.
 * @return The created Office object representing the vertex.
 */
@Override
protected Office createVertex(String label) {
    return new Office(label);
}

/**
 * Creates a new edge between the given vertices with the specified weight.
 *
 * @param v      The source vertex of the edge.
 * @param u      The target vertex of the edge.
 * @param weight The weight of the edge.
 * @return The created Line object representing the edge.
 */
@Override
protected Line createEdge(Office v, Office u, int weight) {
    return new Line(v, u, weight);
}
}