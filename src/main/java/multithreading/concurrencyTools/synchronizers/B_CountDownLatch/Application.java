package multithreading.concurrencyTools.synchronizers.B_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        CommonCounter commonCounter = new CommonCounter();

        for (int i = 1; i < 5; i++) {
            new Thread(new Athlete(latch, i, commonCounter), "Athlete " + i).start();
        }

        Thread.sleep(12000);
        System.out.println(commonCounter.getCounter());
    }
}
