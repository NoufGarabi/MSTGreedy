package com.graphframework;

public class Graph {
    private int verticesNo;
    private int edgeNo;
    private boolean isDigraph;

    /*Constructor that takes verticesNo,edgeNo and isDigraph as parameters
     and returns a graph object */
    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }

    /*Function that takes verticesNo and edgeNo and make a random graph
     that is connected and have random weights */
    private static Graph makeGraph(int verticesNo, int edgeNo) {
        //TODO: implement function
    }

    /*reads the edges and vertices from the text file whose name is 
    specified by the parameter filename and place data in a Graph object */
    private static Graph readGraphFromFile(String filename) {
         //TODO: implement function
    }

    /* is a function that creates an edge object and passes the source vertex v, 
    the target vertex and w the vertex weight as parameters, 
    assigns the target vertex to the adjacent list  */
    private static Edge makeEdge(Vertex target, Vertex source, int weight) {
        //TODO: implement function
    }
    


}
