package com.graphframework;

public class HeapNode {
        Vertex vertex;
        int key;
        Edge edge;
        int index;


        public HeapNode(){}

        public HeapNode(Vertex vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        public Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Vertex vertex) {
            this.vertex = vertex;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int id) {
            this.index = id;
        }

        public Edge getEdge() {
            return edge;
        }

        public void setEdge(Edge edge) {
            this.edge = edge;
        }
      

    
}
