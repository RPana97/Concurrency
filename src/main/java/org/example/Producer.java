package org.example;

import java.util.Random;

public class Producer implements Runnable {
    // Shared buffer to which the producer will add values
    private SharedBuffer buffer;
    // Random number generator to produce random values
    private Random random = new Random();
    // Number of iterations the producer will perform
    private int iterations;

    // Constructor to initialize the producer with the buffer and number of iterations
    public Producer(SharedBuffer buffer, int iterations) {
        this.buffer = buffer;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            // Produce 'iterations' number of random values
            for (int i = 0; i < iterations; i++) {
                // Generate a random number between 0 and 99
                int number = random.nextInt(100);
                // Add the number to the shared buffer
                buffer.add(number);
                System.out.println("Produced: " + number);
                // Simulate the time taken to produce a number by sleeping for 500ms
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            // Handle the interruption and reset the thread's interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
