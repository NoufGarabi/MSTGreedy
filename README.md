# MSTGreedy 👩🏻‍💻

MSTGreedy is a Java implementation of three popular graph algorithms: Kruskal's algorithm, Prim's algorithm, and Dijkstra's algorithm. These algorithms are used to find the minimum spanning tree (MST) of a graph, compute the minimum spanning tree of a weighted graph, and find the shortest path between vertices, respectively. This repository provides efficient and easy-to-use Java implementations of these algorithms.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction 🚀
The Minimum Spanning Tree (MST) is a fundamental concept in graph theory, which finds the subset of edges that connects all the vertices in a graph while minimizing the total edge weight. Kruskal's algorithm and Prim's algorithm are two popular algorithms used to find the MST. Dijkstra's algorithm, on the other hand, is used to find the shortest path between two vertices in a graph. This repository provides Java implementations of these algorithms.

## Features 🌟
- Efficient and simple implementations of Kruskal's algorithm, Prim's algorithm, and Dijkstra's algorithm.
- Support for both directed and undirected graphs.
- Flexible graph representation using adjacency lists.
- The algorithms support weighted graphs with positive edge weights.
- Built-in utility methods for reading and writing graphs from/to files.
- Unit tests to ensure the correctness of the implementations.

## Installation 💻
To use the MSTGreedy library in your Java project, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/NoufGarabi/MSTGreedy.git
   
2. Include the MSTGreedy package in your Java project.
- If you're using an Integrated Development Environment (IDE) such as IntelliJ or Eclipse, you can import the project as a module.
- If you're using a build tool like Maven or Gradle, you can add the necessary dependencies to your project configuration file.

# Usage 🧰
To use the MSTGreedy library in your Java code, you need to follow these steps:

Import the necessary classes from the MSTGreedy package:

```java 
import com.graphframework.Edge;
import com.graphframework.Graph;
import com.graphframework.Vertex;
import com.graphframework.KruskalAlg;
import com.graphframework.PrimAlgor;
```

3. Create an instance of the Graph class and populate it with vertices and edges:

```java 
// Create a new graph with 5 vertices
Graph graph = new Graph(5);

// Add edges to the graph
graph.addEdge(0, 1, 2); // Edge from vertex 0 to vertex 1 with weight 2
graph.addEdge(0, 2, 3); // Edge from vertex 0 to vertex 2 with weight 3
// ...

// Alternatively, you can read the graph from a file using utility methods
// graph = Graph.readFromFile("path/to/graph.txt");
```

4. Use Kruskal's algorithm to find the minimum spanning tree:

```java
// Create an instance of Kruskal's algorithm
KruskalAlg kruskal = new KruskalAlg(graph);

// Find the minimum spanning tree
List<Edge> minimumSpanningTree = kruskal.kruskalMST();

// Print the edges of the minimum spanning tree
minimumSpanningTree.printEdges();
```

5. Use Prim's algorithm to find the minimum spanning tree:

```java
// Create an instance of Prim's algorithm
PrimAlgor prim = new PrimAlgor(graph);

// Find the minimum spanning tree
  List<Edge> MST = prim.MHPrimImplementation();

// Print the edges of the minimum spanning tree
prim.displayResultingMST();
```

6. Use Dijkstra's algorithm to find the shortest path between vertices:

```java
// Create an instance of Dijkstra's algorithm
       DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
// Pass a graph to the instance
       dijkstra.computeDijkstraBasedSPAlg(routeMap);
```

# Contributing 🧑‍🤝‍🧑
Contributions to MSTGreedy are not availible currntely as this is a graded project for CPCS-324

# License 📝
This project is licensed under the MIT License. Feel free to use and modify the code according to your needs.
