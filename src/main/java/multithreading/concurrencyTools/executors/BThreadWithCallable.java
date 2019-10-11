package multithreading.concurrencyTools.executors;

import java.util.concurrent.*;

public class BThreadWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callableTask = () -> "ExecutorService callable task";

        /*
         * Create a thread pool
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        /*
         * "Transfer task control" to FutureTask
         */
        Future future = executorService.submit(callableTask);

        /*
         * executor service shutdow. WARNING!
         */
        executorService.shutdown();

        System.out.println(future.get());
    }
}
