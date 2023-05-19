package com.graphframework;

//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.phonenetworkapp.Line;

public class KruskalAlg extends MSTAlgor {
    public int V, E;
    public static List<Line> edges;
    public static Line[] result;
   

    // Constructer
    public KruskalAlg( Graph g) {
        V = g.getVerticesNum();
        E = g.getEdges().size();
        edges = g.getEdges();
        
    }

    // To return the subset that contain i
    public int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return find(parent, parent[x]);
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
        result = new Line[V];
        int e = 0;
        int i = 0;

        // Sort the array
        
        SortedMethod(edges);

     

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
            
            Line next_edge = edges.get(i++);
            

            int x = find(parent, Integer.parseInt(next_edge.getSource().getLabel()));
            int y = find(parent, Integer.parseInt(next_edge.getTarget().getLabel()));

            if (x != y) {
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }

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
    
    
    //Method to sort the List of edges 
        public List<Line> SortedMethod(List<Line> edge) {

        Collections.sort(edge, new Comparator<Line>() {

            @Override
            public int compare(Line edge1, Line edge2) {
                return edge1.getWeight()- edge2.getWeight();
            }

        });
        return edge;
    }
     

}