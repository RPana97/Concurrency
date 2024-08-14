package org.example;

public class Consumer implements Runnable {
    // Shared buffer from which the consumer will remove values
    private SharedBuffer buffer;
    // Number of iterations the consumer will perform
    private int iterations;

    // Constructor to initialize the consumer with the buffer and number of iterations
    public Consumer(SharedBuffer buffer, int iterations) {
        this.buffer = buffer;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            // Variable to keep track of the sum of consumed values
            int sum = 0;
            // Consume 'iterations' number of values
            for (int i = 0; i < iterations; i++) {
                // Remove a number from the shared buffer
                int number = buffer.remove();
                // Add the number to the sum
                sum += number;
                System.out.println("Consumed: " + number + ", Sum: " + sum);
                // Simulate the time taken to consume a number by sleeping for 1000ms
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Handle the interruption and reset the thread's interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
