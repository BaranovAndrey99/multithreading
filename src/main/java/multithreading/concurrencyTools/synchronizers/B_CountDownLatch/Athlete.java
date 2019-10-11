package multithreading.concurrencyTools.synchronizers.B_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Athlete implements Runnable {
    private CountDownLatch countDownLatch;
    private int athleteSpeed;
    private CommonCounter commonCounter;

    public Athlete(CountDownLatch countDownLatch, int athleteSpeed, CommonCounter commonCounter) {
        this.countDownLatch = countDownLatch;
        this.athleteSpeed = athleteSpeed;
        this.commonCounter = commonCounter;
    }

    @Override
    public void run() {
        try {
            countDownLatch.countDown();

            System.out.println("The athlete " + Thread.currentThread().getName() + " is ready!");

            countDownLatch.await();

            for(int i = 0; i < 100; i++) {
                Thread.sleep(100 / athleteSpeed);
                commonCounter.increment();
            }

            System.out.println("The athlete " + Thread.currentThread().getName() + " finished!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
