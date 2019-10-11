package multithreading.concurrencyTools.synchronizers.C_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private Boat boat;
    private CommonCounter counter;

    public Car(CyclicBarrier cyclicBarrier, Boat boat, CommonCounter counter) {
        this.cyclicBarrier = cyclicBarrier;
        this.boat = boat;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car " + Thread.currentThread().getName() + " go to crossing!");

            Thread.sleep(2000);

            for (int i = 0; i < 100; i++) {
                counter.increment();
            }

            cyclicBarrier.await();

            System.out.println("Car " + Thread.currentThread().getName() + " continued to move!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
