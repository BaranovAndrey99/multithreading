package multithreading.concurrencyTools.executors;

import java.util.concurrent.Executor;

public class AThreadByExecutor {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Executor runnable task");
        };

        Executor executor = (Runnable runnable) -> {
            new Thread(runnable).start();
        };

        executor.execute(task);
        executor.execute(task);
        executor.execute(task);
    }
}
