import java.io.*;
import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        PQueue q = new PQueue();
        char[] charactersList = a.toCharArray();
    
        // processes the scanner input
        for (int i = 0; i < charactersList.length; i++) {
            if (charactersList[i] == '!') {
                // removes the minimum character and prints it
                System.out.print(q.dequeue());
            } else {
                // inserts the character into the queue
                q.enqueue(charactersList[i]);
            }
        }
        
        System.out.println();
        scan.close();
        return;
    }
}

class Heap {

    private char heap[] = new char[255];
    private int size;
    private char NULL;

    // returns current size of heap
    public int getSize() {
        return size;
    }

    // returns whether the node at index j has a right child or not
    public boolean hasRight(int j) {
        return (2 * j + 2) < size;
    }

    // returns index of the right child of the node at index j
    public int right(int j) {
        return 2 * j + 2;
    }

    // returns whether the node at index j has a left child or not
    public boolean hasLeft(int j) {
        return (2 * j + 1) < size;
    }

    // returns index of the left child of the node at index j
    public int left(int j) {
        return 2 * j + 1;
    }

    // returns index of the parent of the node at index j
    public int parent(int j) {
        return (2 * j - 1) / 2;
    }

    // places c at the bottom of the heap and resorts the heap
    public void insert(char c) {
        heap[size] = c;
        size++;
        upHeap(size - 1);
        return;
    }

    // recursively compares the node at index j with its parent and swaps with the parent, if larger than the node
    private void upHeap(int j) {
        int p;
        while (j > 0) {
            p = parent(j);

            if (heap[j] > heap[p]) {
                return;
            }

            swap(j, p);
            j = p;
        }
        return;
    }

    // swaps the values of the nodes at indices j and p
    private void swap(int j, int p) {
        char temp = heap[p];
        heap[p] = heap[j];
        heap[j] = temp;
        return;
    }

    // returns whether the heap is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // if the heap is not empty, returns the node at the top of the heap and resorts the heap
    public char removeMin() {
       if (isEmpty()) {
        return NULL;
       }

       char min = heap[0];
       heap[0] = heap[size - 1];
       size--;
       downHeap(0);
       return min;
    }

    // recursively compares the node at index j with its children and swaps with the smallest child, if smaller than the node
    private void downHeap(int j) {
        while (hasLeft(j)) {
            int smallerIndex = left(j);

            if (hasRight(j) && heap[right(j)] < heap[left(j)]) {
                smallerIndex = right(j);
            }

            if (heap[j] < heap[smallerIndex]) {
                return;
            }

            swap(j, smallerIndex);
            j = smallerIndex;
        }
        return;
    }


}

class PQueue {

    Heap heap;
    
    public PQueue() {
        heap = new Heap();
        return;
    }
    
    // enqueues the character by inserting into the heap
    public void enqueue(char a) {
        heap.insert(a);
        return;
    }
    
    // dequeues a character by removing the smallest character from the heap
    public char dequeue() {
        return heap.removeMin();
    }
}
    