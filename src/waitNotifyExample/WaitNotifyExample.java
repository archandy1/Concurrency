// Klasa wewnętrzna z metodami produce() i consume()
static class waitNotifyExample {

    // Metoda produce() - wątek producenta
    public void produce() throws InterruptedException {
        synchronized (this) {  // Synchronizacja na obiekcie 'this'
            System.out.println("Running the produce mothod...");  // Informacja o rozpoczęciu produkcji
            wait();  // Wątek wchodzi w stan oczekiwania i zwalnia blokadę
            System.out.println("Again, in the produce metohd, resumed after consume");  // Wątek wraca do działania po powiadomieniu
        }
    }

    // Metoda consume() - wątek konsumenta
    public void consume() throws InterruptedException {
        Thread.sleep(1000);  // Symulacja opóźnienia, aby dać czas producentowi na rozpoczęcie
        synchronized (this) {  // Synchronizacja na obiekcie 'this'
            System.out.println("Cousume method is executed...");  // Informacja o rozpoczęciu konsumpcji
            notify();  // Powiadomienie producenta, że może kontynuować
        }
    }
}

public static void main(String[] args) throws InterruptedException {
    waitNotifyExample process = new waitNotifyExample();  // Obiekt procesu, na którym działają oba wątki

    // Wątek producenta
    Thread t1 = new Thread(() -> {
        try {
            process.produce();  // Wywołanie metody produce
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    // Wątek konsumenta
    Thread t2 = new Thread(() -> {
        try {
            process.consume();  // Wywołanie metody consume
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    // Start obu wątków
    t1.start();
    t2.start();

    t1.join();  // Oczekiwanie na zakończenie wątku t1
    t2.join();  // Ocz   ekiwanie na zakończenie wątku t2
}
