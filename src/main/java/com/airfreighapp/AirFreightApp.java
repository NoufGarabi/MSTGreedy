package com.airfreighapp;
import java.io.FileNotFoundException;

import com.graphframework.DBAllSourceSPAlg;


public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException{
        AFRouteMap routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/airfreighapp/map.txt");
        DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
        dijkstra.computeDijkstraBasedSPAlg(routeMap);   
        routeMap.getEdges().get(0).displayInfo();
    }
}
