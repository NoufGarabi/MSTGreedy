/**

PrimAlgor is a class that implements the Prim's algorithm for finding the minimum spanning tree (MST) of a graph.
It extends the MSTAlgor class.
*/
package com.graphframework;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.phonenetworkapp.Line;
import com.phonenetworkapp.Office;

public class PrimAlgor extends MSTAlgor {
List<Edge> MSTResultList;/**
* Constructs a new PrimAlgor object.
* Initializes the MSTResultList as an empty ArrayList.
*/
public PrimAlgor() {
   super();
   MSTResultList =  new ArrayList<>();
}

/**
* Implements the Prim's algorithm to find the minimum spanning tree of the given graph.
* 
* @param graph The graph for which the minimum spanning tree needs to be found.
*/
public void MHPrimImplementation(Graph graph) {

   // Get the number of vertices from the graph
   int numOfVertices = graph.getVerticesNum();
   // Get the adjacency list from the graph
   List<Office> adjList = graph.getAdjList();

   // Get the edges of the graph
   List<Line> edgesList = graph.getEdges();

   int result = 0; // Track the spanning tree cost

   // Keep track of visited vertices
   Set<Vertex> visitedVertices = new HashSet<Vertex>();
   MinHeap minHeap = new MinHeap(edgesList.size()); // Create a new min heap
   // Insert the first vertex into the min heap and give it a cost of 0
   Office firstVertex = adjList.get(0); // Get the first vertex from the adjacency list
   minHeap.insert(new HeapNode(firstVertex ,0, graph.createEdge(firstVertex, firstVertex, 0)));

   while (visitedVertices.size() < numOfVertices) {
       HeapNode poppedNode = minHeap.extractMin(); // Extract the minimum node from the heap
       Office poppedVertex = poppedNode.getOffice(); // Get the vertex from the node
       Line poppedEdge = poppedNode.getLine();
       int cost = poppedNode.getKey(); // Get the key from the node

       // If the vertex is already visited, skip it
       if (visitedVertices.contains(poppedVertex))
           continue;

       // Add the cost to the result of the MST
       result += cost;
       visitedVertices.add(poppedVertex); // Add the vertex to the visited vertices set
       poppedVertex.setVisited(true); // Mark the vertex as visited
       MSTResultList.add(poppedEdge); // Add the minimum edge to the MST

       for (Line e : edgesList) {
           Office source = e.getSource();
           Office target = e.getTarget();

           if (source == poppedVertex && !visitedVertices.contains(target)) {
               minHeap.insert(new HeapNode(target, e.getWeight(), e));
           } else if (target == poppedVertex && !visitedVertices.contains(source)) {
               minHeap.insert(new HeapNode(source, e.getWeight(), e));
           }
       }
   }
   System.out.println("Minimum cost is: " + result);
   displayResultingMST();
}

/**
* Displays the resulting minimum spanning tree (MST) constructed using Prim's algorithm.
*/
@Override
public void displayResultingMST() {
   System.out.println("Following are the edges in the constructed MST (Prim Algorithm)");
   for (int i = 1; i < MSTResultList.size(); i++) {
       MSTResultList.get(i).displayInfo();
   }
}
}