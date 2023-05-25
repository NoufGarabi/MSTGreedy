package com.graphframework;


public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    private static final int INF = Integer.MAX_VALUE;

    public static void computeDijkstraAlg(Graph graph, Vertex source) {
        int n = graph.getAdjList().size();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Vertex[] prev = new Vertex[n];
        String[] thePaths = new String[n];

        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            prev[i] = null;
            thePaths[i] = "";
            visited[i] = false;
        }

        int sourceIndex = graph.getAdjList().indexOf(source);

        dist[sourceIndex] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = findMinDist(dist, visited);
            visited[u] = true;

            Vertex uVertex = graph.getAdjList().get(u);

            for (Edge e : uVertex.getAdjList()) {
                Vertex v = e.getTarget();
                int vIndex = graph.getAdjList().indexOf(v);
                int weight = e.getWeight();
                if (!visited[vIndex] && dist[u] != INF && dist[u] + weight < dist[vIndex]) {
                    dist[vIndex] = dist[u] + weight;
                    prev[vIndex] = uVertex;
                  
                    thePaths[vIndex] = thePaths[u] + " " + v.getLabel()+", ";
                }
            }
        }

        printDistances(dist, source, thePaths, graph);
    }

    private static int findMinDist(int[] dist, boolean[] visited) {
        int minDist = INF;
        int minIndex = 0;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void printDistances(int[] dist, Vertex source, String[] thePaths, Graph graph) {

        for (int i = 0; i < thePaths.length; i++) {

            System.out.println("The path from " + source.getLabel() + " to " + graph.getAdjList().get(i).getLabel() + 
                    " is \n" + thePaths[i] + " The length is " + dist[i] + "\n--------------------------------------");

        }
    }
}
