/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

package com.airfreighapp;

import java.io.FileNotFoundException;

import  com.graphframework.DBAllSourceSPAlg;

public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
       //Read the file of map
       AFRouteMap routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/airfreighapp/map.txt");
       //Create object of type DBAllSourceSPAlg and use dijkstra method
       DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg();
       dijkstra.computeDijkstraBasedSPAlg(routeMap);
       
    }
}
