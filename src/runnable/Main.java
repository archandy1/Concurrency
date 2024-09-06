//class Runner1 implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Runner 1: " + i);
//        }
//    }
//}
//
//class Runner2 implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Runner 2: " + i);
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//        // Create instances of Runner1 and Runner2
//        Runner1 runner1 = new Runner1();
//        Runner2 runner2 = new Runner2();
//
//        // Create threads and pass the Runnable instances to them
//        Thread t1 = new Thread(runner1);
//        Thread t2 = new Thread(runner2);
//
//        // Start the threads
//        t1.start();
//        t2.start();
//    }
//}
