package com.airfreighapp;

import com.graphframework.Vertex;

public class Location extends Vertex{
    String city;

    public Location(String city) {
        this.city = city;
    }

    @Override
    public void setLabel(String label){
        this.setLabel("loc"+label);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void displayInfo() {
        System.out.println("C : city " + this.city);
    }
}
