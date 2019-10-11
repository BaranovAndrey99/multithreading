package multithreading.concurrencyTools.thread;

public class DThreadPriority {
    public static void main(String[] args) {
        /*
         * Changing of thread priority.
         */
        Thread thread4 = new Thread();
        System.out.println("Thread 4 priority: " + thread4.getPriority());

        thread4.setPriority(10);
        System.out.println("Thread 4 priority: " + thread4.getPriority());

        thread4.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread 4 priority: " + thread4.getPriority());
    }
}
