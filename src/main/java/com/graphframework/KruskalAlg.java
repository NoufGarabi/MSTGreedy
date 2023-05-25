package com.graphframework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The KruskalAlg class implements Kruskal's algorithm to find the minimum spanning tree (MST) of a graph.
 * It constructs the MST by iteratively adding the edges with the smallest weight that do not form cycles.
 */
public class KruskalAlg extends MSTAlgor {
    private int V; // Number of vertices
    private int E; // Number of edges
    private List<Edge> edges; // List of edges
    private Edge[] result; // Resulting minimum spanning tree

    /**
     * Constructs a KruskalAlg object with the given graph.
     *
     * @param g The graph for which to find the minimum spanning tree.
     */
    public KruskalAlg(Graph g) {
        V = g.getVerticesNum();
        E = g.getEdges().size();
        edges = g.getEdges();
    }

    /**
     * Finds the root of the subset that contains the vertex x.
     *
     * @param parent The array representing the parent of each vertex in the disjoint sets.
     * @param x      The vertex for which to find the root.
     * @return The root of the subset containing vertex x.
     */
    private int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }

    /**
     * Combines two subsets into a single subset.
     *
     * @param parent The array representing the parent of each vertex in the disjoint sets.
     * @param rank   The array representing the rank of each vertex in the disjoint sets.
     * @param x      The root of the first subset.
     * @param y      The root of the second subset.
     */
    private void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);

        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    /**
     * Performs Kruskal's algorithm to find the minimum spanning tree.
     * The result is stored in the result array.
     */
    public void kruskalMST() {
        result = new Edge[V];
        int e = 0;
        int i = 0;

        // Sort the edges in ascending order of weight
        sortEdges();

        // Array to store the parent and rank of each vertex
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }

        i = 0;
        // Find the least cost edges and construct the minimum spanning tree
        while (e < V - 1) {
            Edge nextEdge = edges.get(i++);

            int x = find(parent, Integer.parseInt(nextEdge.getSource().getLabel()));
            int y = find(parent, Integer.parseInt(nextEdge.getTarget().getLabel()));

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, rank, x, y);
            }
        }
    }

    @Override
    /**
     * Displays the resulting minimum spanning tree and its total cost.
     */
    public void displayResultingMST() {
        int minimumCost = 0;

        for (int i = 0; i < V - 1; i++) {
            result[i].displayInfo();
            minimumCost += result[i].getWeight();
        }
        System.out.println("The cost of the designed phone network: " + minimumCost);
    }

    /**
     * Sorts the list of edges in ascending order of weight.
     */
    private void sortEdges() {
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.getWeight() - edge2.getWeight();
            }
        });
    }
}
