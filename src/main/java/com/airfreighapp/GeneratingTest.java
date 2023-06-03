package com.airfreighapp;

import java.util.Scanner;

import com.graphframework.DBAllSourceSPAlg;
import com.graphframework.Graph;

public class GeneratingTest {
    public static void main(String[] args) {
        // Prompt user for input
        System.out.println("Choose a graph to generate:");
        System.out.println("1. n=2000, m=10000");
        System.out.println("2. n=3000, m=15000");
        System.out.println("3. n=4000, m=20000");
        System.out.println("4. n=5000, m=25000");
        System.out.println("5. n=6000, m=30000");
        System.out.print("> Enter a case to test: ");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        int m;

        // Switch statement to generate the graph based on user choice
        switch (userChoice) {
            case 1:

                graphGenerate(2000, 10000);
                break;
            case 2:

                graphGenerate(3000, 15000);
                break;
            case 3:

                graphGenerate(4000, 20000);
                break;
            case 4:

                graphGenerate(5000, 25000);
                break;
            case 5:

                graphGenerate(6000, 30000);
                break;
            default:
                System.out.println("Invalid choice!");
                System.out.println("Thank you");
                break;
        }

        scanner.close();
    }

    public static void graphGenerate(int vertexNo, int edgeNo) {
        // Create graph and print it
        Graph graph = new Graph(vertexNo, false);
        graph.makeGraph(graph);

        // when testing comment out display dijkstra
        DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();

        long dijkstraStrat = System.currentTimeMillis(); // track time in milli
        dijkstra.computeDijkstraBasedSPAlg(graph);
        long dijkstraEnd = System.currentTimeMillis();
        long dijkstraTotalTime = dijkstraEnd - dijkstraStrat;

        System.out.println("======== Excution Time=========");
        System.out.println("Dijkstra excution time is: " + dijkstraTotalTime + " ms");

    }
}
