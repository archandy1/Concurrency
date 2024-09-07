package multithreading;

public class Volatile {

    public static void main(String[] args) {

        Worker worker = new Worker();

        Thread t1 = new Thread(worker);
        t1.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("algorithm is terminated");

    }

}
