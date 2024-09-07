package processor;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    private final List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private int value = 0;

    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    lock.wait();  // Producer waits and releases the lock
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }


    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for adding items...");
                    value = 0;
                    lock.wait();  // Consumer waits and releases the lock
                } else {
                    System.out.println("Removing: " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();

        // Producer thread
        Thread t1 = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread t2 = new Thread(() -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();
    }
}
