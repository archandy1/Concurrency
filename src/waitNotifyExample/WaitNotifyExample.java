// Internal class with produce() and consume() methods
static class waitNotifyExample {

    // <> produce() - producer thread
    public void produce() throws InterruptedException {
        synchronized (this) {  // Synchronization on the 'this' object
            System.out.println("Running the produce method...");  // Information about the start of production
            wait();  // The thread goes into a waiting state and releases the lock
            System.out.println("Again, in the produce method, resumed after consume");  // The thread resumes after being notified
        }
    }

    // consume() method - consumer thread
    public void consume() throws InterruptedException {
        Thread.sleep(1000);  // Simulate delay to give the producer time to start
        synchronized (this) {  // Synchronization on the 'this' object
            System.out.println("Consume method is executed...");  // Information about the start of consumption
            notify();  // Notify the producer that it can continue
        }
    }
}

public static void main(String[] args) throws InterruptedException {
    waitNotifyExample process = new waitNotifyExample();  // Process object on which both threads operate

    // Producer thread
    Thread t1 = new Thread(() -> {
        try {
            process.produce();  // Call the produce method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    // Consumer thread
    Thread t2 = new Thread(() -> {
        try {
            process.consume();  // Call the consume method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    // Start both threads
    t1.start();
    t2.start();

    t1.join();  // Wait for thread t1 to finish
    t2.join();  // Wait for thread t2 to finish
}
