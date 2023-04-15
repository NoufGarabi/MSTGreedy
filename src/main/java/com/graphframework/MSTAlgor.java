package com.graphframework;

public abstract class MSTAlgor {
    private Edge[] MSTResultList;

    public Edge[] getMSTResultList() {
        return MSTResultList;
    }

    public void setMSTResultList(Edge[] mSTResultList) {
        MSTResultList = mSTResultList;
    }

    public MSTAlgor(Edge[] mSTResultList) {
        MSTResultList = mSTResultList;
    }

    public abstract void displayResultingMST();
}
