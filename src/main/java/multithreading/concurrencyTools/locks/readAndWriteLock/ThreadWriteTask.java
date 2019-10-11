package multithreading.concurrencyTools.locks.readAndWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadWriteTask implements Runnable {
    private CommonResource commonResource;
    private ReentrantReadWriteLock locker;

    public ThreadWriteTask(CommonResource commonResource, ReentrantReadWriteLock locker) {
        this.commonResource = commonResource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.writeLock().lock();
        try {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " have write lock.");
                commonResource.increment();
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.writeLock().unlock();
        }
    }
}
