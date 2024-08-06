package org.example;

public class Main {
    public static void main(String[] args) {
        final int iterations = 10;
        SharedBuffer buffer = new SharedBuffer(10); // Buffer with a maximum size of 10

        Producer producer = new Producer(buffer, iterations);
        Consumer consumer = new Consumer(buffer, iterations);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

