package synchronization;

public class MonitorLock {
    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public static void main(String[] args) {
        MonitorLock counter1 = new MonitorLock();
        MonitorLock counter2 = new MonitorLock();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter2.increment();
            }
        });

        t1.start();
        t2.start();
    }
}