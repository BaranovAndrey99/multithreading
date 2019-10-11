package multithreading.concurrencyTools.synchronizers.A_Semaphore;

import java.util.concurrent.Semaphore;

public class ThreadIncrement implements Runnable {
    private CommonResource commonResource;
    private Semaphore semaphore;

    public ThreadIncrement(CommonResource commonResource, Semaphore semaphore) {
        this.commonResource = commonResource;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " awaitng permission.");
            semaphore.acquire();
            commonResource.increment();
            System.out.println(Thread.currentThread().getName() + " does increment");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " frees permission.");
        semaphore.release();
    }
}
