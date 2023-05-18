package com.graphframework;
import java.io.IOException;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        // Print header
        System.out.println("\t ======== Comparison of two of the minimum-spanning-tree algorithms ========\n");
        System.out.println("\t\t\t\tKruskal and min-heap-based Prim\n");

        // Prompt user for input
        System.out.println("Choose a graph to generate:");
        System.out.println("1. n=1000, m={10000, 15000, 25000}");
        System.out.println("2. n=5000, m={15000, 25000}");
        System.out.println("3. n=10000, m={15000, 25000}");
        System.out.print("> Enter a case to test: ");
        int userChoice = scanner.nextInt();
        int m;

        // Switch statement to generate the graph based on user choice
        switch (userChoice) {
            case 1:
                System.out.print("> Enter number of edges (10000, 15000, or 25000): ");
                m = scanner.nextInt();
                graphGenerate(1000, m);
                break;
            case 2:
                System.out.print("> Enter number of edges (15000 or 25000): ");
                m = scanner.nextInt();
                graphGenerate(5000, m);
                break;
            case 3:
                System.out.print("> Enter number of edges (15000 or 25000): ");
                m = scanner.nextInt();
                graphGenerate(10000, m);
                break;
            default:
                System.out.println("Invalid choice!");
                System.out.println("Thank you");
                break;
        }


        // Read graph from file
        // Graph graph = Graph.readGraphFromFile("GraphFile.txt");
    }

    public static void graphGenerate(int vertexNo, int edgeNo) {
        // Create graph and print it
        BluePrintsGraph graph = new BluePrintsGraph(vertexNo, false);
        graph.makeGraph(graph);
        graph.printGraph();

        System.out.println("=========== Kruskal ================");
        KruskalAlg m = new KruskalAlg(vertexNo, edgeNo, graph);
        m.kruskalMST();

        System.out.println();
        System.out.println("=========== Prim ================");
        PrimAlgor prim = new PrimAlgor();
        prim.MHPrimImplementation(graph);
    }
}
