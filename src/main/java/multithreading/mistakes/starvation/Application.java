package multithreading.mistakes.starvation;

public class Application {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task1 = () -> {
            while (true) {
                for(int i = 0; i < 50; i++) {
                    synchronized (counter) {
                        counter.incrementCounter();
                    }
                }
            }
        };

        Runnable task2 = () -> {
            while (true) {
                synchronized (counter) {
                    counter.incrementCounter();
                }
            }
        };

        Thread thread1 = new Thread(task1, "SLOW");
        Thread thread2 = new Thread(task2, "FAST");

        thread1.start();
        thread2.start();

    }
}
