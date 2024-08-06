package org.example;

public class Consumer implements Runnable {
    private SharedBuffer buffer;
    private int iterations;

    public Consumer(SharedBuffer buffer, int iterations) {
        this.buffer = buffer;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            int sum = 0;
            for (int i = 0; i < iterations; i++) {
                int number = buffer.remove();
                sum += number;
                System.out.println("Consumed: " + number + ", Sum: " + sum);
                Thread.sleep(1000); // Simulate time taken to consume a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
