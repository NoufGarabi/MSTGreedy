/**

PrimAlgor is a class that implements the Prim's algorithm for finding the minimum spanning tree (MST) of a graph.
It extends the MSTAlgor class.
*/
package com.graphframework;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimAlgor extends MSTAlgor {
List<Edge> MSTResultList;
/**

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
public List<Edge> MHPrimImplementation(Graph graph) {

   // Get the number of vertices from the graph
   int numOfVertices = graph.getVerticesNum();
   // Get the adjacency list from the graph
   List<Vertex> adjList = graph.getAdjList();


   // Keep track of visited vertices
   Set<Vertex> visitedVertices = new HashSet<Vertex>();
   MinHeap minHeap = new MinHeap(numOfVertices * numOfVertices); // Create a new min heap

   // Insert the first vertex into the min heap and give it a cost of 0
   Vertex firstVertex = adjList.get(0); // Get the first vertex from the adjacency list
   minHeap.insert(new HeapNode(firstVertex ,0, graph.createEdge(firstVertex, firstVertex, 0)));

   while (visitedVertices.size() < numOfVertices && !minHeap.isEmpty()) {
       HeapNode poppedNode = minHeap.pop(); // Extract the minimum node from the heap
       Vertex poppedVertex = poppedNode.getVertex(); // Get the vertex from the node
       Edge poppedEdge = poppedNode.getEdge();
    //    int cost = poppedNode.getKey(); // Get the key from the node

       // If the vertex is already visited, skip it
       if (visitedVertices.contains(poppedVertex))
           continue;

       visitedVertices.add(poppedVertex); // Add the vertex to the visited vertices set
       MSTResultList.add(poppedEdge); // Add the minimum edge to the MST

       
       for (Edge e : poppedVertex.getAdjList()) {
        Vertex source = e.getSource();
        Vertex target = e.getTarget();

           if (source.equals(poppedVertex) && !visitedVertices.contains(target)) {
               minHeap.insert(new HeapNode(target, e.getWeight(), e));
               
           } else if (target.equals(poppedVertex) && !visitedVertices.contains(source)) {
               minHeap.insert(new HeapNode(source, e.getWeight(), e));

           }
        
        }
    }
   
return MSTResultList;
}

/**
* Displays the resulting minimum spanning tree (MST) constructed using Prim's algorithm.
*/
@Override
public void displayResultingMST() {

    int result =0;
   for (int i = 1; i < MSTResultList.size(); i++) {
    MSTResultList.get(i).displayInfo();
    result+= MSTResultList.get(i).getWeight();
   }
   System.out.println("The cost of designed phone network: " + result);
}
}