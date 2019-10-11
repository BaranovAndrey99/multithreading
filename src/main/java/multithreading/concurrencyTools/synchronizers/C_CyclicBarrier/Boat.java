package multithreading.concurrencyTools.synchronizers.C_CyclicBarrier;

import java.util.ArrayList;
import java.util.List;

public class Boat implements Runnable {

    @Override
    public void run() {
        System.out.println("START CROSSING");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CROSSING COMPLETED");
    }
}
