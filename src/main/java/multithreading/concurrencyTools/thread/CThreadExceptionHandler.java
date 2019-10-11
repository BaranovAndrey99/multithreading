package multithreading.concurrencyTools.thread;

public class CThreadExceptionHandler {
    public static void main(String[] args) {
        /*
         * Thread exception handler.
         */
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " run!");
            System.out.println(2 / 0);
        };

        Thread thread = new Thread(task);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("EXCEPTION!!!");
            }
        });

        thread.start();

    }
}
