package com.graphframework;

 
// Main class (MinHeap)
class MinHeap {
 
    // Member variables of this class
    private Edge[] Heap;
    private int size;
    private int maxsize;
 
    // Initializing front as static with unity
    private static final int FRONT = 1;
 
    // Constructor of this class
    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new Edge[this.maxsize + 1];
        Edge e = new Edge(null, null, Integer.MIN_VALUE);
        Heap[0] = e;
    }
 
    // Method 1
    // Returning the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) { return pos / 2; }
 
    // Method 2
    // Returning the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) { return (2 * pos); }
 
    // Method 3
    // Returning the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    // Method 4
    // Returning true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {
 
        if (pos > (size / 2)) {
            return true;
        }
 
        return false;
    }
 
    // Method 5
    // To swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
 
        Edge tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    // Method 6
    // To heapify the node at pos
   private void minHeapify(int pos)
   {     
     if(!isLeaf(pos)){
       int swapPos= pos;
       // swap with the minimum of the two children
       // to check if right child exists. Otherwise default value will be '0'
       // and that will be swapped with parent node.
       if(rightChild(pos)<=size)
          swapPos = Heap[leftChild(pos)].getWeight() <Heap[rightChild(pos)].getWeight()?leftChild(pos):rightChild(pos);
       else
         swapPos= leftChild(pos);
        
       if(Heap[pos].getWeight() >Heap[leftChild(pos)].getWeight() || Heap[pos].getWeight() > Heap[rightChild(pos)].getWeight()){
         swap(pos,swapPos);
         minHeapify(swapPos);
       }
        
     }      
   }
 
    // Method 7
    // To insert a node into the heap
    public void insert(Edge element)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current].getWeight() < Heap[parent(current)].getWeight()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    // Method 8
    // To print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);
 
            // By here new line is required
            System.out.println();
        }
    }
 
    // Method 9
    // To remove and return the minimum
    // element from the heap
    public Edge remove()
    {
 
        Edge popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }
}