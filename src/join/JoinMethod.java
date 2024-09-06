package join;

class Runner1 extends Thread {

    @Override
    public void run(){
        for (int i = 1; i <= 10; ++i) {
            try {
                Thread.sleep(10);
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 2: " + i);
        }
    }
}

public class JoinMethod {
    public static void main(String[] args) {

        // not parallel execution
        // achieve multi-threading
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished with threads....");
    }
}