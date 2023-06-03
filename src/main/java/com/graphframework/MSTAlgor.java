/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

/**
 * The MSTAlgor class is an abstract class representing an algorithm for finding
 * the minimum spanning tree (MST) of a graph.
 * It provides a framework for implementing specific MST algorithms.
 */
package com.graphframework;


public abstract class MSTAlgor {
    private Edge[] MSTResultList; // Stores the resulting MST edges

    /**
     * Abstract method to display the resulting minimum spanning tree.
     * Each specific MST algorithm must implement this method.
     * It should display the MST in a meaningful way, such as printing the edges or visualizing the graph.
     */
    public abstract void displayResultingMST();
}
