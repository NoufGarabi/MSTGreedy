package com.airfreighapp;
import java.io.FileNotFoundException;



public class AirFreightApp {
    public static void main(String[] args) throws FileNotFoundException{
        AFRouteMap routeMap = AFRouteMap.readGraphFromFile("src/main/java/com/phonenetworkapp/network.txt");
        routeMap.printGraph();

    
    }
}
