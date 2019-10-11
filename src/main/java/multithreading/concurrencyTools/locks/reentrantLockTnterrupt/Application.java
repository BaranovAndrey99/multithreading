package multithreading.concurrencyTools.locks.reentrantLockTnterrupt;

import java.util.concurrent.locks.ReentrantLock;

public class Application {
    public static void main(String[] args) throws InterruptedException{
        CommonResource commonResource = new CommonResource();
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(new ThreadTask(commonResource, reentrantLock));
        Thread thread2 = new Thread(new ThreadTask(commonResource, reentrantLock));
        Thread thread3 = new Thread(new ThreadTask(commonResource, reentrantLock));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(commonResource.getCounter());
    }
}
