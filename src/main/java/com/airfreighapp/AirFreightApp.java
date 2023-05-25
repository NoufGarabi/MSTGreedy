package com.airfreighapp;
import java.io.FileNotFoundException;

import com.graphframework.DBAllSourceSPAlg;
import com.graphframework.Graph;



public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException{
        Graph routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/airfreighapp/map.txt");
        DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
        dijkstra.computeDijkstraBasedSPAlg(routeMap);

    
    }
}
