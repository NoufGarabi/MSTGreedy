package com.airfreighapp;

import java.io.FileNotFoundException;

import com.graphframework.Graph;


public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException{
        AFRouteMap a = (AFRouteMap)Graph.readGraphFromFile("src/main/java/com/phonenetworkapp/network.txt");
    }
}
