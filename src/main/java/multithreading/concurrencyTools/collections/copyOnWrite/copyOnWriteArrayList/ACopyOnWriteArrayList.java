package multithreading.concurrencyTools.collections.copyOnWrite.copyOnWriteArrayList;

public class ACopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {
        Example example = new Example();

        Runnable task1 = () -> {
            System.out.println("THREAD 1:");
            example.printCollection(true);
        };

        Runnable task2 = () -> {
            System.out.println("THREAD 2:");
            example.printCollection(false);
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread1.join();
        thread2.start();
    }
}
