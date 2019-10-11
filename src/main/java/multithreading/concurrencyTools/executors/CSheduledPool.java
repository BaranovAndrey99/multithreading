package multithreading.concurrencyTools.executors;

import java.util.Timer;
import java.util.concurrent.*;

public class CSheduledPool {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("ExecutorService callable task");
        };

        /*
         * Create a thread pool
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        /*
         * "Transfer task control" to FutureTask
         */
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);

        /*
         * executor service shutdow. WARNING!
         */
        scheduledExecutorService.shutdown();
    }
}
