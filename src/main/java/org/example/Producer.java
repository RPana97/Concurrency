package org.example;
import java.util.Random;

public class Producer implements Runnable {
    private SharedBuffer buffer;
    private Random random = new Random();
    private int iterations;

    public Producer(SharedBuffer buffer, int iterations) {
        this.buffer = buffer;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                int number = random.nextInt(100);
                buffer.add(number);
                System.out.println("Produced: " + number);
                Thread.sleep(500); // Simulate time taken to produce a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
