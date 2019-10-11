package multithreading.concurrencyTools.synchronizers.C_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Boat boat = new Boat();
        CommonCounter commonCounter = new CommonCounter();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, boat);

        for (int i = 0; i < 10; i++) {
            new Thread(new Car(cyclicBarrier, boat, commonCounter), "Car " + i).start();
            Thread.sleep(400);
        }

        Thread.sleep(10000);

        System.out.println(commonCounter.getCounter());
    }
}
