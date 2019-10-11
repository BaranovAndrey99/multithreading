package multithreading.concurrencyTools.synchronizers.A_Semaphore;

import java.util.concurrent.Semaphore;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

        CommonResource commonResource = new CommonResource();

        new Thread(new ThreadIncrement(commonResource, semaphore), "1").start();
        new Thread(new ThreadIncrement(commonResource, semaphore), "2").start();
        new Thread(new ThreadIncrement(commonResource, semaphore), "3").start();
    }
}
