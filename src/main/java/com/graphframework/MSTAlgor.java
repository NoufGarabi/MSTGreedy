package com.graphframework;

public abstract class MSTAlgor {
    private Edge[] MSTResultList;


    public abstract void displayResultingMST();


    public Edge[] getMSTResultList() {
        return MSTResultList;
    }


    public void setMSTResultList(Edge[] mSTResultList) {
        MSTResultList = mSTResultList;
    }
}
