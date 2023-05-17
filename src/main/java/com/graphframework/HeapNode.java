package com.graphframework;

public class HeapNode {
        Office office;
        int key;
        Edge edge;
        int index;
        Line line;


        public HeapNode(){}


        public HeapNode(Office vertex, int key, Line edge) {
            this.office = vertex;
            this.key = key;
            this.line = edge;
        }
        public Office getOffice() {
            return office;
        }

        public void setOffice(Office office) {
            this.office = office;
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

        public Line getLine() {
            return line;
        }

        public void setLine(Line line) {
            this.line = line;

        }
      

    
}
