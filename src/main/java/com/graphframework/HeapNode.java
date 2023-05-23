/**

The HeapNode class represents a node in a heap data structure.
It contains information about an office, a key value, an edge, an index, and a line.
**/
package com.graphframework;

public class HeapNode {
Vertex vertex; // The office associated with the node
int key; // The key value of the node
Edge edge; // The edge associated with the node
public Edge getEdge() {
    return edge;
}

public void setEdge(Edge edge) {
    this.edge = edge;
}

int index; // The index of the node

/**
 * Default constructor for the HeapNode class.
 */
public HeapNode() {}

/**
 * Constructor for the HeapNode class that sets the office, key, and edge.
 *
 * @param target The office associated with the node.
 * @param key    The key value of the node.
 * @param e   The edge associated with the node.
 */
public HeapNode(Vertex target, int key, Edge e) {
    this.vertex = target;
    this.key = key;
    this.edge = e;
}

/**
 * Returns the office associated with the node.
 *
 * @return The office associated with the node.
 */
public Vertex getVertex() {
    return this.vertex;
}

/**
 * Sets the office associated with the node.
 *
 * @param office The office to be associated with the node.
 */
public void setVertex(Vertex vertex) {
    this.vertex = vertex;
}

/**
 * Returns the key value of the node.
 *
 * @return The key value of the node.
 */
public int getKey() {
    return key;
}

/**
 * Sets the key value of the node.
 *
 * @param key The key value to be set.
 */
public void setKey(int key) {
    this.key = key;
}

/**
 * Returns the index of the node.
 *
 * @return The index of the node.
 */
public int getIndex() {
    return index;
}

/**
 * Sets the index of the node.
 *
 * @param id The index to be set.
 */
public void setIndex(int id) {
    this.index = id;
}

/**
 * Returns the line associated with the node.
 *
 * @return The line associated with the node.
 */
}