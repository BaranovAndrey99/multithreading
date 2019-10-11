package multithreading.concurrencyTools.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ETheadDaemon {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger simpleCounter = new AtomicInteger();
        AtomicInteger daemonCounter = new AtomicInteger();

        Runnable task = () -> {
            for(int i = 0; i < 10000; i++) {
                if(Thread.currentThread().isDaemon()) {
                    daemonCounter.getAndIncrement();
                } else {
                    simpleCounter.getAndIncrement();
                }
            }
        };

        Thread thread = new Thread(task,"Non-Daemon");
        Thread threadDaemon = new Thread(task,"Daemon");

        threadDaemon.setDaemon(true);

        thread.start();
        threadDaemon.start();

        thread.join();
        threadDaemon.join();

        System.out.println("Simple counter: " + simpleCounter);
        System.out.println("Daemon counter: " + daemonCounter);
    }
}
