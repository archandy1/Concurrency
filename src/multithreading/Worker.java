package multithreading;

public class Worker implements Runnable {

    private volatile boolean terminated;

    @Override
    public void run() {

        while (!terminated){
            System.out.println("Working class is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}

