/**

The KruskalAlg class represents an implementation of the Kruskal's algorithm
for finding the minimum spanning tree of a graph.
*/
package com.graphframework;
import java.util.List;

import com.phonenetworkapp.Line;

public class KruskalAlg extends MSTAlgor {
    public int V, E;
    public static List<Line> edges;
    public static Edge[] result;
    public static boolean isVisited;
    
    /**
     * Constructor for the KruskalAlg class.
     *
     * @param v The number of vertices in the graph.
     * @param e The number of edges in the graph.
     * @param g The graph containing the edges.
     */
    public KruskalAlg(int v, int e, Graph g) {
        V = v;
        E = e;
        edges = g.getEdges();
    }
    
    /**
     * Finds the subset that contains the given element.
     *
     * @param parent The parent array representing the disjoint sets.
     * @param x      The element to find.
     * @return The subset that contains the element.
     */
    public int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }
    
    /**
     * Constructs the union of the disjoint sets.
     *
     * @param parent The parent array representing the disjoint sets.
     * @param rank   The rank array for union-by-rank optimization.
     * @param x      The root of the first set.
     * @param y      The root of the second set.
     */
    public void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
    
        if (rank[xroot] < rank[yroot]) {
            parent[xroot] = yroot;
        } else if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
        } else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }
    
    /**
     * Applies Kruskal's algorithm to find the minimum spanning tree of the graph.
     */
    public void kruskalMST() {
        result = new Line[V];
        int e = 0;
        int i = 0;
    
        for (i = 0; i < V; ++i)
            result[i] = new Line();
    
        // Sort the edges in non-decreasing order of weight
        for (int z = 0; z < edges.size(); z++) {
            for (int j = z + 1; j < edges.size(); j++) {
                if (edges.get(z).getWeight() > edges.get(j).getWeight()) {
                    Line temp = edges.get(z);
                    edges.set(z, edges.get(j));
                    edges.set(j, temp);
                }
            }
        }
    
        // Array to find the parent, rank of the vertice
        int[] parent = new int[V];
        int[] rank = new int[V];
    
        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }
    
        i = 0;
        // Finding the least cost edges and constructing the minimum spanning tree
        while (e < V - 1) {
            Line next_edge = edges.get(i++);
    
            int x = find(parent, Integer.parseInt(next_edge.getSource().getLabel()));
            int y = find(parent, Integer.parseInt(next_edge.getTarget().getLabel()));
    
            if (x != y) {
                next_edge.getTarget().setVisited(true);
                next_edge.getSource().setVisited(true);
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }
    
        displayResultingMST();
    }
    
    @Override
    /**
     * Displays the resulting minimum spanning tree (MST) using Kruskal's algorithm.
     */
    public void displayResultingMST() {
        System.out.println("Following are the edges in the constructed MST (Kruskal Algorithm)");
        int minimumCost = 0;
    
        for (int i = 0; i < V - 1; i++) {
            result[i].displayInfo();
            minimumCost += result[i].getWeight();
        }
    
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }
}    