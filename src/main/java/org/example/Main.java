package org.example;

public class Main {
    public static void main(String[] args) {
        // Number of iterations for producer and consumer
        final int iterations = 10;

        // Create a shared buffer with a maximum size of 10
        SharedBuffer buffer = new SharedBuffer(10);

        // Create producer and consumer objects with the shared buffer and number of iterations
        Producer producer = new Producer(buffer, iterations);
        Consumer consumer = new Consumer(buffer, iterations);

        // Create threads for the producer and consumer
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start the producer and consumer threads
        producerThread.start();
        consumerThread.start();

        try {
            // Wait for both threads to finish
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            // Handle the interruption and reset the thread's interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
