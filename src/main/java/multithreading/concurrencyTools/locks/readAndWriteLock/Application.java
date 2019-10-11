package multithreading.concurrencyTools.locks.readAndWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Application {
    public static void main(String[] args) throws InterruptedException{
        CommonResource commonResource = new CommonResource();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        Thread threadWrite1 = new Thread(new ThreadWriteTask(commonResource, reentrantReadWriteLock));
        Thread threadWrite2 = new Thread(new ThreadWriteTask(commonResource, reentrantReadWriteLock));

        Thread threadRead1 = new Thread(new ThreadReadTask(commonResource, reentrantReadWriteLock));
        Thread threadRead2 = new Thread(new ThreadReadTask(commonResource, reentrantReadWriteLock));

        threadWrite1.start();
        threadWrite2.start();
        threadRead1.start();
        threadRead2.start();

        threadWrite1.join();
        threadWrite2.join();
        threadRead1.join();
        threadRead2.join();

        System.out.println(commonResource.getCounter());
    }
}
