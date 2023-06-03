package com.airfreighapp;

import java.io.FileNotFoundException;

import com.graphframework.DBAllSourceSPAlg;
public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
        //Read the file of map
        AFRouteMap routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/airfreighapp/map.txt");
        //Create object of type DBAllSourceSPAlg and use dijkstra method
        DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
        dijkstra.computeDijkstraBasedSPAlg(routeMap);
        
}

}
