/*
 Names : 
 Nouf Khaled Algarabi 2006172 b8
 Wedyan Fawaz Almushaddaq 2105113 b8
 Aya Habib Khan 2010298 b10
 Joud Jamal Alkishi 2011026 b8
 */

package com.graphframework;

import java.util.Arrays;

/**
 * MinHeap class represents a minimum heap.
 * It has a capacity, size, and an array of heap nodes.
 */
class MinHeap {
    int capacity;
    int size; // The current size
    HeapNode[] heap;
    int[] indecies; // To decrease the key

    /**
     * MinHeap constructor.
     * 
     * @param capacity The maximum capacity of the heap.
     */
    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new HeapNode[capacity + 1];
        indecies = new int[capacity];

        // this node is a placeholder only
        heap[0] = new HeapNode();
        heap[0].vertex = new Vertex("");
        heap[0].key = Integer.MIN_VALUE;
        heap[0].index = -1;
        indecies = new int[capacity];
        Arrays.fill(indecies, -1); // Initialize all elements with -1
        size = 0;
    }

    /**
     * Insert a heapNode into the heap.
     * 
     * @param node The node to be inserted.
     */
    public void insert(HeapNode node) {
        heap[++size] = node;
        indecies[node.index] = size;
        bubbleUp(size);
    }

    /**
     * Perform the bubble up operation to maintain the heap property.
     * 
     * @param position The position of the node.
     */
    public void bubbleUp(int position) {
        int parentIdx = position / 2;
        int currentIdx = position;
        while (currentIdx > 0 && heap[parentIdx].key > heap[currentIdx].key) {
            HeapNode currentNode = heap[currentIdx];
            HeapNode parentNode = heap[parentIdx];
            indecies[currentNode.index] = parentIdx;
            indecies[parentNode.index] = currentIdx;
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx / 2;
        }
    }

    /**
     * Extract the minimum node from the heap.
     * 
     * @return The minimum node.
     */
    public HeapNode pop() {
        HeapNode min = heap[1];
        HeapNode lastNode = heap[size];
        indecies[lastNode.index] = 1;
        heap[1] = lastNode;
        heap[size] = null;
        sinkDown(1);
        size--;
        return min;
    }

    /**
     * Perform the sink down operation to maintain the heap property.
     * 
     * @param position The position of the node.
     */
    public void sinkDown(int position) {
        int theSmallest = position;
        int leftChild = 2 * position;
        int rightChild = 2 * position + 1;
        if (leftChild < heapSize() && heap[theSmallest].key > heap[leftChild].key) {
            theSmallest = leftChild;
        }
        if (rightChild < heapSize() && heap[theSmallest].key > heap[rightChild].key) {
            theSmallest = rightChild;
        }
        if (theSmallest != position) {
            HeapNode smallestNode = heap[theSmallest];
            HeapNode positionNode = heap[position];
            indecies[smallestNode.index] = position;
            indecies[positionNode.index] = theSmallest;
            swap(position, theSmallest);
            sinkDown(theSmallest);
        }
    }

    /**
     * Check if the heap is empty.
     * 
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the heap.
     * 
     * @return The size of the heap.
     * 
     */
    public int heapSize() {
        return size;
    }

    /**
     * Swap two nodes in the heap.
     * 
     * @param index1 The index of the first node.
     * @param index2 The index of the second node.
     */
    public void swap(int index1, int index2) {
        HeapNode temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
        indecies[heap[index1].index] = index1;
        indecies[heap[index2].index] = index2;
    }

    public void decreaseKey(int newKey, int id) {
        // get the edges which key's needs the decrease;
        int index = indecies[id];

        // get the node and update its value
        HeapNode node = heap[index];
        node.key = newKey;
        bubbleUp(index);
    }

}