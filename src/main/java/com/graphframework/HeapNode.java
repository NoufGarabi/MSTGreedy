/**

The HeapNode class represents a node in a heap data structure.
It contains information about an office, a key value, an edge, an index, and a line.
**/
package com.graphframework;
import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public class HeapNode {
String office; // The office associated with the node
int key; // The key value of the node
Edge edge; // The edge associated with the node
int index; // The index of the node
Line line; // The line associated with the node

/**
 * Default constructor for the HeapNode class.
 */
public HeapNode() {}

/**
 * Constructor for the HeapNode class that sets the office, key, and edge.
 *
 * @param target The office associated with the node.
 * @param key    The key value of the node.
 * @param edge   The edge associated with the node.
 */
public HeapNode(String target, int key, Line edge) {
    this.office = target;
    this.key = key;
    this.line = edge;
}

/**
 * Returns the office associated with the node.
 *
 * @return The office associated with the node.
 */
public String getOffice() {
    return office;
}

/**
 * Sets the office associated with the node.
 *
 * @param office The office to be associated with the node.
 */
public void setOffice(String office) {
    this.office = office;
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
public Line getLine() {
    return line;
}

/**
 * Sets the line associated with the node.
 *
 * @param line The line to be associated with the node.
 */
public void setLine(Line line) {
    this.line = line;
}
}