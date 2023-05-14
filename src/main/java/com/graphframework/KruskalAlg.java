package com.graphframework;

//import java.util.Arrays;
import java.util.List;

public class KruskalAlg extends MSTAlgor {
    public int V, E;
    public static List<Edge> edges;
    public static Edge[] result;

    // Constructer
    public KruskalAlg(int v, int e, Graph g) {
        super(result);
        V = v;
        E = e;
        edges = g.getEdges();
    }

    // To return the subset that contain i
    public int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    // To construct union of the disjoint
    public void union(int[] parent, int[] rank, int x, int y) {
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

    public void kruskalMST() {
        result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // Sort the array
        for (int z = 0; z < edges.size(); z++) {
            for (int j = z + 1; j < edges.size(); j++) {
                if (edges.get(z).getWeight() > edges.get(j).getWeight()) {
                    Edge temp = edges.get(z);
                    edges.set(z, edges.get(j));
                    edges.set(j, temp);
                }
            }
        }

        // Print the edges in increasing order
        // for (int j = 0; j < edges.size(); j++) {
        // System.out.println(edges.get(j).getWeight());
        // }

        // Array to find the parent, rank of the vertice
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }

        i = 0;
        // finding the least cost edges and construct rhe minimum spanning tree
        while (e < V - 1) {
            Edge next_edge = edges.get(i++);

            int x = find(parent, next_edge.getSource().getLabel());
            int y = find(parent, next_edge.getTarget().getLabel());

            if (x != y) {
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }

        // for (int j = 0; j < V - 1; j++) {
        // result[j].displayInfo();
        // }

        displayResultingMST();
    }

    @Override
    // Method to print the result
    public void displayResultingMST() {
        System.out.println("Following are the edges in the constructed MST (Kruskal Algorithm)");
        int minimumCost = 0;

        for (int i = 0; i < V - 1; i++) {
            System.out.println(result[i].getSource().getLabel() + " -- " + result[i].getTarget().getLabel() + " == "
                    + result[i].getWeight());
            minimumCost += result[i].getWeight();

        }
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);

    }

}
