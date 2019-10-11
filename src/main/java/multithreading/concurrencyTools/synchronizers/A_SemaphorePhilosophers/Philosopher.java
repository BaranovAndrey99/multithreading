package multithreading.concurrencyTools.synchronizers.A_SemaphorePhilosophers;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    private Semaphore semaphore;
    private int numberOfMeals;

    public Philosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.numberOfMeals = 0;
    }

    @Override
    public void run() {
        try {
            while (numberOfMeals < 3) {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " sat at the table");

                Thread.sleep(500);

                numberOfMeals++;

                System.out.println(Thread.currentThread().getName() + " leaves the table");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
