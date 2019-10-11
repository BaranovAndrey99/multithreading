package multithreading.concurrencyTools.synchronizers.A_SemaphorePhilosophers;

import java.util.concurrent.Semaphore;

public class Application {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        new Thread(new Philosopher(semaphore), "Kant").start();
        new Thread(new Philosopher(semaphore), "Marx").start();
        new Thread(new Philosopher(semaphore), "Engels").start();
        new Thread(new Philosopher(semaphore), "Platon").start();
        new Thread(new Philosopher(semaphore), "Diogen").start();
    }
}
