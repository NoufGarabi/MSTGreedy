package com.graphframework;

import com.airfreighapp.Location;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    //Infinity value
    private static final int INF = Integer.MAX_VALUE;
    //Array to store distance
    static int[] dist;
    //Array to store locations
    static Location[] locations;
    //Array to save the paths
    static String[] arr;
        
    static Graph graph;
    static Vertex source;

    //Method to compute dijkstra algorithm 
    public static void computeDijkstraAlg(Graph graph1, Vertex vertex) {
        graph = graph1;
        source = vertex;
        //Define number of vertex
        int n = graph.getAdjList().size();
        //New objects to the arrays
        locations = new Location[n];
        arr = new String[n];
        dist = new int[n];
        //Array to check if the vertex visited
        boolean[] visited = new boolean[n];
        //Array to store the previous vertex
        Vertex[] prev = new Vertex[n];

        //Initialize distances with infinity 
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            arr[i] = "";

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
                    //Add the path to v 
                    arr[vIndex] = arr[u] + (char) (Integer.parseInt(v.getLabel()) + 65) + "";

                }
            }
        }

    }

    //Method to find minimum distance 
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
        //To check if this vertex has at least one path to other vertices 
        boolean flag = false;
        //The source label
        char s = (char) (Integer.parseInt(source.getLabel()) + 65);
        System.out.println("Location " + s);

        for (int i = 0; i < graph.adjList.size(); i++) {

            //Check that there is path from source to other
            if (dist[i] == 0 || dist[i] == INF) {
                continue;
            }
            //There is path so it is true
            flag = true;
            System.out.print("loc." + s);

            //Loop to print the entire path from sorce to the target
            for (int j = 0; j < arr[i].length(); j++) {
                //Assign the city and call displayInfo
                locations[i] = new Location(arr[i].charAt(j) + "");
                locations[i].displayInfo();

            }

            //Print Route length
            System.out.println(": Route length :" + dist[i]);

        }
        //If there is no path from this source
        if (!flag) {
            System.out.println("There are no paths from " + s + " to other vertices");

        }
        
        System.out.println("\n-------------------------------------------\n");   

    }
}
