package multithreading.concurrencyTools.locks.readAndWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadReadTask implements Runnable {
    private CommonResource commonResource;
    private ReentrantReadWriteLock locker;

    public ThreadReadTask(CommonResource commonResource, ReentrantReadWriteLock locker) {
        this.commonResource = commonResource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.readLock().lock();
        try {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " have read lock.");
                commonResource.getCounter();
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.readLock().unlock();
        }
    }
}
