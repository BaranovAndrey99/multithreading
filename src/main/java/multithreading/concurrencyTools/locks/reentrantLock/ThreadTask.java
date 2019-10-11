package multithreading.concurrencyTools.locks.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTask implements Runnable {
    private CommonResource commonResource;
    private ReentrantLock locker;

    public ThreadTask(CommonResource commonResource, ReentrantLock locker) {
        this.commonResource = commonResource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " have lock.");
                commonResource.increment();
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
