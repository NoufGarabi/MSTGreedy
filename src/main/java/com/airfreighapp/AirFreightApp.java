package com.airfreighapp;
import java.io.FileNotFoundException;

import com.graphframework.Graph;



public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException{
        Graph routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/phonenetworkapp/network.txt");
        routeMap.printGraph();

    
    }
}
