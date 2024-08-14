package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    // A queue to represent the buffer
    private Queue<Integer> buffer = new LinkedList<>();
    // The maximum size of the buffer
    private int maxSize;

    // Constructor to initialize the buffer with a specified maximum size
    public SharedBuffer(int maxSize) {
        this.maxSize = maxSize;
    }

    // Synchronized method to add a value to the buffer
    public synchronized void add(int value) throws InterruptedException {
        // Wait if the buffer is full
        while (buffer.size() == maxSize) {
            wait();
        }
        // Add the value to the buffer
        buffer.add(value);
        // Notify all waiting threads that the buffer state has changed
        notifyAll();
    }

    // Synchronized method to remove a value from the buffer
    public synchronized int remove() throws InterruptedException {
        // Wait if the buffer is empty
        while (buffer.isEmpty()) {
            wait();
        }
        // Remove and return the value from the buffer
        int value = buffer.remove();
        // Notify all waiting threads that the buffer state has changed
        notifyAll();
        return value;
    }
}
