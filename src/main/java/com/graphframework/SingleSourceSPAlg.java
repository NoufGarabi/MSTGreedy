package com.graphframework;

import com.airfreighapp.Location;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    //Infinity value
    private static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static Graph graph;
    static Vertex source;
    static Location[] locations;

    //Method to compute dijkstra algorithm 
    public static void computeDijkstraAlg(Graph graph1, Vertex vertex) {
        graph = graph1;
        source = vertex;
        //Define number of vertex
        int n = graph.getAdjList().size();
        //Array to store distance
        dist = new int[n];
        //Array to check if the vertex visited
        boolean[] visited = new boolean[n];
        //Array to store the previous vertex
        Vertex[] prev = new Vertex[n];
        //Array to store locations
        locations = new Location[n];

        //Initialize distances with infinity 
        for (int i = 0; i < n; i++) {
            dist[i] = INF;

        }

        //Get the index of the source vertex and assign it destance with 0 
        int sourceIndex = graph.getAdjList().indexOf(source);
        dist[sourceIndex] = 0;

        //Loop to calulate the distance from source vertex to all vertexs in the graph
        for (int i = 0; i < n - 1; i++) {
            //Find the min vertex and assign it to u and make it visited
            int u = findMinDist(dist, visited);
            visited[u] = true;

            //Get the vertex of min value
            Vertex uVertex = graph.getAdjList().get(u);

            //Loop to calulate the distance between the u (min vertex) all its neighbors 
            for (Edge e : uVertex.getAdjList()) {
                //find the target and the index, weight
                Vertex v = e.getTarget();
                int vIndex = graph.getAdjList().indexOf(v);
                int weight = e.getWeight();

                if (!visited[vIndex] && dist[u] != INF && dist[u] + weight < dist[vIndex]) {
                    //Add the u destance to v
                    dist[vIndex] = dist[u] + weight;
                    prev[vIndex] = uVertex;

                }
            }
        }

        // DisplayDijkstra(dist, source, graph, locations);
    }

    //Method to find min distance 
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
//Method to display the result

    public void DisplayDijkstra() {
        //To count the distances from source to others
        int count = 0;
        //The source label
        char s = (char) (Integer.parseInt(source.getLabel()) + 65);
        System.out.println("Location " + s);
        System.out.print("loc." + s);
        for (int i = 0; i < graph.adjList.size(); i++) {

            //Check 
            if (dist[i] == 0 || dist[i] == INF) {
                continue;
            }

            //add the distance to count
            count += dist[i];
            //Assign the city and label to locations and call displayInfo
            locations[i] = new Location(dist[i] + "");
            locations[i].setLabel(graph.getAdjList().get(i).getLabel());
            locations[i].displayInfo();

        }
        //Print Route length
        System.out.println(": Route length :" + count);
        System.out.println("-------------------------------------------");

    }
}
