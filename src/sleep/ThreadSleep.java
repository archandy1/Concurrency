package sleep;

class Runner1 extends Thread {

    @Override
    public void run(){
        for (int i = 1; i <= 10; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 1: " + i);
        }
    }
}

class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2: " + i);
        }
    }
}


public class ThreadSleep {
    public static void main(String[] args) {

        // not parallel execution
        // achieve multi-threading
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();

        t1.start();
        t2.start();
    }
}