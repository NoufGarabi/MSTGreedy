/**
 * The MSTAlgor class is an abstract class representing an algorithm for finding
 * the minimum spanning tree (MST) of a graph.
 * It provides a framework for implementing specific MST algorithms.
 */
package com.graphframework;

import com.phonenetworkapp.Line;

public abstract class MSTAlgor {
    private Line[] MSTResultList; // Stores the resulting MST edges

    /**
     * Abstract method to display the resulting minimum spanning tree.
     * Each specific MST algorithm must implement this method.
     * It should display the MST in a meaningful way, such as printing the edges or visualizing the graph.
     */
    public abstract void displayResultingMST();
}
