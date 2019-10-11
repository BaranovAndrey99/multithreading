package multithreading.concurrencyTools.thread;

public class AThreadGroupDefault {
    public static void main(String[] args) {
        /*
         * Default thread group.
         */
        Thread thread1 = new Thread();
        System.out.println("Thread 1 group: " + thread1.getThreadGroup());
        thread1.start();
    }
}
